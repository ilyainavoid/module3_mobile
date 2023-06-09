package com.example.myapplication.logic

import java.util.*
import kotlin.math.pow

fun calculate(container: Container, expression: String): Pair<String, Int> {
    val exp = expression.replace("\\s".toRegex(), "")
    if (exp.isEmpty()) {
        return Pair(emptyInput(), 0)
    }
    val (prepared, expStatus) = preparingExpression(container, exp)
    val (lineStatus, correctLine) = lineCheck(exp)
    if (correctLine == 0) {
        return Pair(emptyInput(), 0)
    }
    if (expStatus == 0) {
        return Pair(lineStatus, 0)
    }
    return RPNtoAnswer(toRPN(prepared))
}

private fun getPriority(symbol: Char): Int {
    return when (symbol) {
        '*', '/', '%' -> 3
        '+', '-' -> 2
        '(' -> 1
        ')' -> -1
        else -> 0
    }
}

private fun toRPN(expression: String): String {
    var current = ""
    val stack: Stack<Char> = Stack<Char>()
    var priority: Int
    for (i in expression.indices) {
        priority = getPriority(expression[i])
        when (priority) {
            0 -> current += expression[i]
            1 -> stack.push(expression[i])
            2, 3 -> {
                current += " "
                while (!stack.empty()) {
                    if ((getPriority(stack.peek()) >= priority)) {
                        current += stack.pop()
                    } else break
                }
                stack.push(expression[i])
            }

            -1 -> {
                current += " "
                while (getPriority(stack.peek()) != 1) current += stack.pop()
                stack.pop()
            }

            else -> {
                return "Error"
            }
        }
    }
    while (!stack.empty()) current += stack.pop()
    return current
}

private fun RPNtoAnswer(RPN: String): Pair<String, Int> {
    var operand = String()
    val stack: Stack<Int> = Stack<Int>()
    var i = 0
    while (i < RPN.length) {
        if (RPN[i] == ' ') {
            i++
            continue
        }
        if (getPriority(RPN[i]) == 0) {
            while (RPN[i] != ' ' && (getPriority(RPN[i]) == 0)) {
                operand += RPN[i++]
                if (i == RPN.length) break
            }
            try {
                stack.push(operand.toInt())
            } catch (e: NumberFormatException) {
                return Pair(unexpectedSymbol(operand), 0)
            }
            operand = String()
        }
        if (i == RPN.length) break
        if (getPriority(RPN[i]) > 1) {
            try {
                val a: Int = stack.pop()
                val b: Int = stack.pop()
                when (RPN[i]) {
                    '+' -> stack.push(b + a)
                    '-' -> stack.push(b - a)
                    '*' -> stack.push(b * a)
                    '/' -> {
                        try {
                            stack.push(b / a)
                        } catch (e: Exception) {
                            return Pair(divisionByZero(), 0)
                        }
                    }

                    '%' -> {
                        try {
                            stack.push(b % a)
                        } catch (e: Exception) {
                            return Pair(divisionByZero(), 0)
                        }
                    }

                    else -> {
                        return Pair(unexpectedSymbol(RPN[i].toString()), 0)
                    }
                }
            } catch (e: EmptyStackException) {
                return Pair(incorrectExpression(), 0)
            }
        }
        i++
    }
    return Pair(OK(), stack.pop())
}

private fun preparingExpression(container: Container, expression: String): Pair<String, Int> {
    var exp = expression
    var preparedExpression = String()
    val regArr = "([A-Za-z]+[A-Za-z0-9_]*)\\[[A-Za-z0-9 +%*/_#^-]*]".toRegex()
    var array = regArr.find(exp)
    while (array != null) {
        val (arrName, arrIndex) = indexCount(container, array.value)
        if (arrIndex == -1) {
            return Pair(arrName, 0)
        }
        if (!container.isArrayExist(arrName)) {
            return Pair(undefinedArray(arrName), 0)
        }
        val arrValue = container.getArrayValue(arrName, arrIndex)
        var fromArrToNum = arrValue.toString()
        if (arrValue!!.toInt() < 0) {
            fromArrToNum = "($fromArrToNum)"
        }
        exp = exp.replace(array.value, fromArrToNum)
        array = regArr.find(exp)
    }
    val reg = "[A-Za-z]+[A-Za-z0-9_]*".toRegex()
    var variable = reg.find(exp)
    while (variable != null) {
        if (!container.isVariableExist(variable.value)) {
            return Pair(undefinedVariable(variable.value), 0)
        }
        val varValue = container.getVariableValue(variable.value)
        var fromVarToNum = varValue.toString()
        if (varValue!!.toInt() < 0) {
            fromVarToNum = "($fromVarToNum)"
        }
        exp = exp.replaceRange(variable.range, fromVarToNum)
        variable = reg.find(exp)
    }

    for (j in exp.indices) {
        if (exp[j] == '-') {
            if ((j == 0) || (exp[j - 1] == '(')) {
                preparedExpression += "0"
            }
        }
        preparedExpression += exp[j]
    }
    return Pair(preparedExpression, 1)
}

private fun lineCheck(string: String): Pair<String, Int> {
    var str = string.replace("[A-Za-z-+*/0-9()%_\\[\\]]".toRegex(), "")
    if (str.isNotEmpty()) {
        return Pair(unexpectedSymbol(str), 0)
    }
    val reg =
        "([-+% ]+[0-9_]+[A-Za-z_]+[0-9]*[-+%* ]*)|(\\b[0-9_]+[A-Za-z_]+[0-9]*)|(\\b[_][0-9]+)".toRegex()
    if (reg.find(string) != null) {
        return Pair(incorrectExpression(), 0)
    }
    str = string.replace("[A-Za-z-+*/0-9%^#_\\[\\]]".toRegex(), "")
    val bracket1 = str.replace("\\(".toRegex(), "")
    val bracket2 = str.replace("\\)".toRegex(), "")
    if (bracket1.length != bracket2.length) {
        return Pair(incorrectExpression(), 0)
    }
    return Pair(OK(), 1)
}

fun defineInput(heap: Container, expression: String): Triple<String, String, Int> {
    val arr = "[A-Za-z]+[\\[(\\d+_*^#)\\]]".toRegex()
    val variable = "[A-Za-z]+[A-Za-z0-9_]*".toRegex()

    if (arr.find(expression) != null) {
        val (name, index) = indexCount(heap, expression)
        if (index == -1) {
            return Triple(name, tagNothing(), 0)
        }
        if (heap.isArrayExist(name) && index >= 0 && index < heap.getArraySize(name)!!.toInt()) {
            return Triple(tagArray(), name, index)
        }
    }
    if (variable.find(expression) != null) {
        if (heap.isVariableExist(expression)) {
            return Triple(tagVariable(), expression, 0)
        }
    }
    return Triple(inputError(), tagNothing(), 0)
}

private fun indexCount(container: Container, arr: String): Pair<String, Int> {
    var array = arr
    var index = -1
    var arrayName = ""
    val reg = "([A-Za-z]+[A-Za-z0-9_]*)\\[[A-Za-z0-9 +*/%_^#-]*]".toRegex()
    while (reg.find(array) != null) {
        val arg = "\\[[A-Za-z0-9 +*/_%^#-]*]".toRegex().find(array)
        arrayName = "[A-Za-z]+[A-Za-z0-9_]*".toRegex().find(reg.find(array)!!.value)!!.value
        if (arg != null) {
            val arm = arg.value.replace("[", "").replace("]", "")
            val (status, result) = calculate(container, arm)
            array = array.replace(arm, result.toString())
            index = result
            if (!container.isArrayExist(arrayName)) {
                return Pair(undefinedArray(arrayName), -1)
            }
            if (index >= container.getArraySize(arrayName)!!.toInt() || index < 0) {
                return Pair(indexOutOfRange(), -1)
            }
            if (status != OK()) {
                return Pair(status, -1)
            }
            val arrayValue = container.getArrayValue(arrayName, result)
            array = array.replace(reg.find(array)!!.value, arrayValue.toString())
        }
    }
    return Pair(arrayName, index)
}
package com.example.myapplication.logic

import java.util.*
import kotlin.math.pow

fun calculate(container: Container, expression: String): Pair<String,Int> {
    val exp = expression.replace(" ", "")
    if (exp.isEmpty()){
        return Pair(" ", 0)
    }
    val (prepared, expStatus) = preparingExpression(container, exp)
    val lineStatus = lineCheck(exp)
    if (lineStatus == 0) {
        return Pair(" ", 0)
    }
    if (expStatus == 0) {
        return Pair(" ", 0)
    }
    return Pair(OK(), RPNtoAnswer(toRPN(prepared)))
}

private fun getPriority(symbol:Char):Int{
    return when(symbol){
        '*', '/', '%' -> 3
        '+', '-' -> 2
        '(' -> 1
        ')' -> -1
        else -> 0
    }
}

private fun toRPN(expression: String): String{
    var current = ""
    val stack: Stack<Char> = Stack<Char>()
    var priority: Int
    for (i in expression.indices){
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

private fun RPNtoAnswer(RPN: String): Int{
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
                return 0
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
                            return 0
                        }
                    }
                    '%' -> {
                        try {
                            stack.push(b % a)
                        } catch (e: Exception) {
                            return 0
                        }
                    }
                    else -> {
                        return  0
                    }
                }
            } catch (e: EmptyStackException) {
                return 0
            }
        }
        i++
    }
    return stack.pop()
}



private fun preparingExpression(container: Container, expression: String): Pair<String, Int> {
    var exp = expression
    var preparedExpression = String()
    val reg = "[A-Za-z]+[A-Za-z0-9_]*".toRegex()
    var variable = reg.find(exp)
    while (variable != null) {
        if (!container.isVariableExist(variable.value)) {
            return Pair("", 0)
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

private fun lineCheck(string: String): Int {
    var str = string.replace("[A-Za-z-+*/0-9()%_\\[\\]]".toRegex(), "")
    if (str.isNotEmpty()) {
        return 0
    }
    val reg =
        "([-+% ]+[0-9_]+[A-Za-z_]+[0-9]*[-+%* ]*)|(\\b[0-9_]+[A-Za-z_]+[0-9]*)|(\\b[_][0-9]+)".toRegex()
    if (reg.find(string) != null) {
        return 0
    }
    str = string.replace("[A-Za-z-+*/0-9%^#_\\[\\]]".toRegex(), "")
    val bracket1 = str.replace("\\(".toRegex(), "")
    val bracket2 = str.replace("\\)".toRegex(), "")
    if (bracket1.length != bracket2.length) {
        return 0
    }
    return 1
}

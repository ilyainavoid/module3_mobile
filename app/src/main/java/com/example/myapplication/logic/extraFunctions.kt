package com.example.myapplication.logic

import com.example.myapplication.navigation.CodeEditor
import com.example.myapplication.navigation.Console
import androidx.compose.runtime.mutableStateListOf

fun variableCheck(variable: String): Boolean {
    val str = variable.replace("[A-Za-z0-9_]".toRegex(), "")
    if (str.isNotEmpty()) {
        return false
    }
    return true
}

fun toVarList(vars: String): List<String> {
    return vars.replace("[\\s*]".toRegex(), "")
        .replace("[,;]".toRegex(), " ")
        .split("[\\s*]".toRegex()).filter { it.isNotEmpty() }
}

fun expressionComparator(numberLeft: Int, numberRight: Int, comparator: String): Boolean {
    when (comparator) {
        ">" -> return (numberLeft > numberRight)
        ">=" -> return (numberLeft >= numberRight)
        "<" -> return (numberLeft < numberRight)
        "<=" -> return (numberLeft <= numberRight)
        "==" -> return (numberLeft == numberRight)
        "!=" -> return (numberLeft != numberRight)
    }
    return false
}

fun runProgram() {
    Console.adapterConsole.clearMessageList()
    Console.adapterConsole.addMessage(programStart())
    var isOk = true
    for (i in 0 until CodeEditor.controller.blockList.size) {
        CodeEditor.controller.blockList[i].indexListBlocks = i
        CodeEditor.controller.blockList[i].initFlag = true
        if (CodeEditor.controller.blockList[i].status != OK()) {
            Console.adapterConsole.clearMessageList()
            Console.adapterConsole.addMessage("${CodeEditor.controller.blockList[i].status} in block ${i + 1}")
            isOk = false
            break
        } else if (CodeEditor.controller.blockList[i].type == "Output") {
            CodeEditor.controller.blockList[i].runBlock()
        }
    }
    if (isOk) {
        Block.isWorking = true
        CodeEditor.controller.blockList[0].run()
    }
}
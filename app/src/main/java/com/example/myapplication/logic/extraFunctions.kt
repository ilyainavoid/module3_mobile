package com.example.myapplication.logic

import com.example.myapplication.navigation.CodeEditor
import com.example.myapplication.navigation.Console
import androidx.compose.runtime.mutableStateListOf
import com.example.myapplication.navigation.ConsoleContent

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

fun runIfBlock(block: ConditionIf){

}

fun runConditionBlocks(block: Block): Boolean{
    when (block.type){
        "ConditionIf" ->{
            block.runBlock()
            return block.nextBlock == Begin()
        }
        "ConditionIfElse"->{
            block.runBlock()
            if(block.nextBlock == Begin()){

            }
        }
        "For Cycle" ->{

        }
        "WhileCycle"->{

        }
    }
     return false

}

fun runProgram() {
    Console.adapterConsole.clearMessageList()
    Console.adapterConsole.addMessage(programStart())
    var isOk = true

    for (i in 0 until CodeEditor.controller.blockList.size) {

        CodeEditor.controller.blockList[i].initFlag = true
        if (CodeEditor.controller.blockList[i].status != OK()) {
            Console.adapterConsole.clearMessageList()
            Console.adapterConsole.addMessage("${CodeEditor.controller.blockList[i].status} in block ${i + 1}")
            isOk = false
            break
        }
    }
    if (isOk) {
        if (!connectionBlocks()) {
            Console.adapterConsole.addMessage(programFinish("Fail"))
            return
        }
        Block.isWorking = true
        CodeEditor.controller.blockList[0].run()
        var flag = true
        for (i in 1 until CodeEditor.controller.blockList.size) {
            if (CodeEditor.controller.blockList[i].type != "ConditionIf" ||
                CodeEditor.controller.blockList[i].type != "ConditionIfElse" ||
                CodeEditor.controller.blockList[i].type != "CycleWhile" ||
                CodeEditor.controller.blockList[i].type != "For Cycle"
            ) {
                if(flag){
                    CodeEditor.controller.blockList[i].runBlock()
                }
            }
            else if(CodeEditor.controller.blockList[i].type == "End"){
                flag = if(flag){
                    false
                } else true
            }
            else{
                 flag = runConditionBlocks(CodeEditor.controller.blockList[i])
            }
        }
    }
}
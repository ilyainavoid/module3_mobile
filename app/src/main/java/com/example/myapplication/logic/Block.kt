package com.example.myapplication.logic

import com.example.myapplication.MainActivity
import com.example.myapplication.navigation.CodeEditor
import com.example.myapplication.navigation.Console
import java.util.*

open class Block {
    companion object {
        var blockStack: Stack<Block> = Stack()
        var container = CodeEditor.controller.containerStorage
        var isWorking = false
    }

    var inputEditLeft: String = ""
    var inputEditMiddle: String = ""
    var inputEditRight: String = ""
    var inputComparator: String = ">="
    var indexComparator: Int = 0
    var valueVar: String = ""


    var inputForCycle: String = ""
    var indexListBlocks = 0

    var adapterConsole = Console.adapterConsole

    lateinit var begin: Begin
    lateinit var end: End
    lateinit var exit: Exit
    lateinit var beginElse: Begin
    lateinit var endElse: End

    // Флаг. В while, if, if-else заставляет выполниться initVar() единожды
    // т.к. он перезаписывает блоки выхода Exit
    var initFlag = true

    var nextBlock: Block? = null
    var prevBlock: Block? = null

    var type: String = ""
    var status: String = OK()

    fun accessContainer(): Container {
        return container
    }

    open fun initVariables() {
    }

    open fun runBlock() {
        status = OK()
    }

    open fun kickRunning() {}

    open fun run() {
        if (type == "ConsoleInput") {
            runBlock()
        } else {
            runBlock()
            when {
                nextBlock == null -> {
                    isWorking = false
                }

                status == OK() -> {
                    blockStack.push(nextBlock)
                }

                else -> {
                    isWorking = false
                    adapterConsole.addMessage(programFinish(status))
                }
            }
        }
    }
}
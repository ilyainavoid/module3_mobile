package com.example.myapplication.logic
import com.example.myapplication.MainActivity
import java.util.*

open class Block {
    companion object{
        var blockStack: Stack<Block> = Stack()
        var container: Container = Container()
        var isWorking = false
    }
    var inputEditLeft: String = ""
    var inputEditRight: String = ""
    var inputComparator: String = ">="
    var indexComparator: Int = 0
    var valueVar: String = ""


    var indexListBlocks = 0
    //lateinit var adapterConsole: ConsoleAdapter
    //lateinit var adapterBlocks: BlocksAdapter
    //lateinit var holder: BlocksAdapter.ViewHolder
    var activity: MainActivity? = null

    lateinit var begin: Begin
    lateinit var end: End
    lateinit var exit: Exit
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
                    //activity?.disconnectAllBlocks()
                    //adapterConsole.addMessage(programFinish(status))
                    //adapterBlocks.notifyItemChanged(indexListBlocks)
                }
                status == OK() -> {
                    blockStack.push(nextBlock)
                }
                else -> {
                    isWorking = false
                    //activity?.disconnectAllBlocks()
                    //adapterConsole.addMessage(programFinish(status))
                    //adapterBlocks.notifyItemChanged(indexListBlocks)
                }
            }
        }
    }

}
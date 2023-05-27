package com.example.myapplication.logic

/**
 *  Блок условия IfElse.
 *  Позволяет выполнять определенные наборы команд при выполнении и не выполнении условия.
 **/
class ConditionIfElse : Block() {
    private var expressionLeft: String = ""
    private var expressionRight: String = ""
    private var comparator: String = ">="

    init {
        type = "ConditionIfElse"
    }

    override fun initVariables() {
        expressionLeft = inputEditLeft
        expressionRight = inputEditRight
        comparator = inputComparator

       begin.adapterConsole = this.adapterConsole
        end.adapterConsole = this.adapterConsole
        beginElse.adapterConsole = this.adapterConsole
        endElse.adapterConsole = this.adapterConsole
        exit = Exit()
        exit.adapterConsole = this.adapterConsole
        initFlag = false

    }

    override fun runBlock() {
        super.runBlock()
        if (initFlag) initVariables()
        connectBlocks(end, exit, clear = false)
        connectBlocks(endElse, exit, clear = false)
        nextBlock?.let {
            if (nextBlock != begin && nextBlock != beginElse && nextBlock != exit &&
                nextBlock != end && nextBlock != endElse && nextBlock != null
            )
                connectBlocks(exit, it, clear = false)
        }

        if (comparator !in allComparators) {
            status = invalidComparator()
            return
        }

        val calculateLeft = calculate(container, expressionLeft)
        val calculateRight = calculate(container, expressionRight)
        if ((calculateLeft.first != OK()) || (calculateRight.first != OK())) {
            status = if (calculateLeft.first == OK()) calculateRight.first else calculateLeft.first
            return
        }
        if (expressionComparator(
                calculateLeft.second,
                calculateRight.second,
                comparator
            )
        ) {
            connectBlocks(this, begin, false)
        } else {
            connectBlocks(this, beginElse, false)
        }
    }
}
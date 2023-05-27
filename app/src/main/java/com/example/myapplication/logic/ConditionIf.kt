package com.example.myapplication.logic

class ConditionIf : Block() {
    private var expressionLeft: String = ""
    private var expressionRight: String = ""
    private var comparator: String = ">="

    init {
        type = "ConditionIf"
    }

    override fun initVariables() {
        expressionLeft = inputEditLeft
        expressionRight = inputEditRight
        comparator = inputComparator
        begin.adapterConsole = adapterConsole
        end.adapterConsole = adapterConsole
        exit = Exit()
        exit.adapterConsole = adapterConsole
        exit = Exit()

        initFlag = false

    }

    override fun runBlock() {
        super.runBlock()
        if (initFlag) initVariables()
        connectBlocks(end, exit, clear = false)

        nextBlock?.let {
            if (nextBlock != begin && nextBlock != exit && nextBlock != end && nextBlock != null)
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
            connectBlocks(this, exit, false)
        }
    }
}
package com.example.myapplication.logic

//for(int i = 0; i < 10; i = i + 1)
class ForCycle : Block() {
    private var varName: String = ""
    private var leftExpression: String = ""
    private var middleExpression: String = ""
    private var rightExpression: String = ""
    private var comparator: String = ">"


    fun setBlockInput(
        name: String,
        expressionFirst: String,
        expressionSecond: String,
        expressionThird: String,
        expressionComparator: String
    ) {
        varName = name
        leftExpression = expressionFirst
        middleExpression = expressionSecond
        rightExpression = expressionThird
        comparator = expressionComparator
    }

    init {
        type = "For Cycle"
    }

    override fun initVariables() {
        varName = inputForCycle
        leftExpression = inputEditLeft
        middleExpression = inputEditMiddle
        rightExpression = inputEditRight

        comparator = inputComparator

        exit = Exit()

        initFlag = false
    }

    override fun runBlock() {
        super.runBlock()

        if (initFlag) initVariables()
        connectBlocks(end, this, clear = false)

        nextBlock?.let {
            if (nextBlock != begin && nextBlock != exit && nextBlock != end && nextBlock != null) {
                connectBlocks(exit, it, clear = false)
            }
        }

        if (comparator !in allComparators) {
            status = invalidComparator()
        }

        val leftCalculated = calculate(container, leftExpression)
        val middleCalculated = calculate(container, middleExpression)
        val rightCalculated = calculate(container, rightExpression)

        if (expressionComparator(rightCalculated.second, middleCalculated.second, comparator)) {
            connectBlocks(this, begin, clear = false)
        } else connectBlocks(this, end, clear = false)
    }
}
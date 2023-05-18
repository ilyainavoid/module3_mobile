package com.example.myapplication.logic

import androidx.compose.foundation.interaction.HoverInteraction

class WhileCycle: Block() {
    private var leftExpression: String = ""
    private var rightExpression: String = ""
    private var comparator: String = "=="

    //для цикла for


    fun setBlockInput( expressionLeft: String, expressionRight: String, expressionComparator: String = "==") {
        leftExpression = expressionLeft
        rightExpression = expressionRight
        comparator = expressionComparator
    }

    init {
        type = "While Cycle"
    }

    override fun initVariables() {
        leftExpression = inputEditLeft
        rightExpression = inputEditRight
        comparator = inputComparator

        exit = Exit()
        //добавить всмете с консолью
        initFlag = false
    }

    override fun runBlock() {
        super.runBlock()

        if(initFlag) initVariables()
        connectBlocks(end,this, clear = false)

        nextBlock?.let {
            if(nextBlock != begin && nextBlock != exit && nextBlock != end && nextBlock != null){
                connectBlocks(exit, it, clear = false)
            }
        }

        if(comparator !in allComparators){
            status = invalidComparator()
        }
        val leftCalculated = calculate(accessContainer(), leftExpression)
        val rightCalculated = calculate(accessContainer(), rightExpression)

        if(leftCalculated.first != OK() || rightCalculated.first != OK()){
            status = if(rightCalculated.first == OK()){
                leftCalculated.first
            } else{
                rightCalculated.first
            }
        }

        if(expressionComparator(leftCalculated.second, rightCalculated.second, comparator)){
            connectBlocks(this, begin, clear = false)
        }
        else connectBlocks(this, exit,clear = false )
    }
}
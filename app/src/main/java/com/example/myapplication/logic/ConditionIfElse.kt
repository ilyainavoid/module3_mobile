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

//        begin.adapterConsole = this.adapterConsole
//        end.adapterConsole = this.adapterConsole
//        beginElse.adapterConsole = this.adapterConsole
//        endElse.adapterConsole = this.adapterConsole
        exit = Exit()
//        exit.adapterConsole = this.adapterConsole
//        begin.adapterBlocks = this.adapterBlocks
//        end.adapterBlocks = this.adapterBlocks
//        exit.adapterBlocks = this.adapterBlocks
//        beginElse.adapterBlocks = this.adapterBlocks
//        endElse.adapterBlocks = this.adapterBlocks
        initFlag = false

    }

    override fun runBlock() {
        super.runBlock()
        // Выполняем initVar() единожды
        if (initFlag) initVariables()
        // Соединяем блоки концов условия с выходом - блоком с которым соединен if-else блок
        connectBlocks(end, exit, clear = false)
        connectBlocks(endElse, exit, clear = false)
        // Соединяем выход с блоком, после if-else, если это не блок логики if-else
        nextBlock?.let {
            if (nextBlock != begin && nextBlock != beginElse && nextBlock != exit &&
                nextBlock != end && nextBlock != endElse && nextBlock != null)
                connectBlocks(exit, it, clear = false)
        }

        // Проверяем правильность операторов сравнения
        if (comparator !in allComparators) {
            status = invalidComparator()
            return
        }

        // Высчитываем левую и правую часть для сравнения
        val calculateLeft = calculate(container, expressionLeft)
        val calculateRight = calculate(container, expressionRight)
        // Проверяем правильность вычислений
        if ((calculateLeft.first != OK()) || (calculateRight.first != OK())) {
            status = if (calculateLeft.first == OK()) calculateRight.first else calculateLeft.first
            return
        }
        // Сравниваем
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
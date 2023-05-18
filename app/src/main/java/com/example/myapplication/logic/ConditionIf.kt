//package com.example.myapplication.logic
//
//class ConditionIf: Block() {
//    private var expressionLeft: String = ""
//    private var expressionRight: String = ""
//    private var comparator: String = ">="
//
//    init{
//        type = "ConditionIf"
//    }
//    override fun initVariables()
//    {
//       expressionLeft = inputEditLeft
//       expressionRight = inputEditRight
//       comparator = inputComparator
//
//        begin.adapterConsole = adapterConsole
//        end.adapterConsole = adapterConsole
//        exit = Exit()
//        exit.adapterConsole = adapterConsole
//        begin.adapterBlocks = this.adapterBlocks
//        end.adapterBlocks = this.adapterBlocks
//        exit.adapterBlocks = this.adapterBlocks
//        initFlag = false
//
//    }
//    override fun runBlock() {
//        super.runBlock()
//        // Выполняем initVar() единожды
//        if (initFlag) initVariables()
//        // Соединяем блок конца при выполнении условия с выходом - блоком которым соединен if блок
//        connectBlocks(end, exit, clear = false)
//
//        // Соединяем выход с блоком, после if, если это не блок логики if
//        nextBlock?.let {
//            if (nextBlock != begin && nextBlock != exit && nextBlock != end && nextBlock != null)
//                connectBlocks(exit, it, clear = false)
//        }
//
//        // Проверяем правильность операторов сравнения
//        if (comparator !in allComparators) {
//            status = invalidComparator()
//            return
//        }
//
//        // Высчитываем левую и правую часть для сравнения
//        val calculateLeft = calculate(container, expressionLeft)
//        val calculateRight = calculate(container, expressionRight)
//        // Проверяем правильность вычислений
//        if ((calculateLeft.first != OK()) || (calculateRight.first != OK())) {
//            status = if (calculateLeft.first == OK()) calculateRight.first else calculateLeft.first
//            return
//        }
//        // Сравниваем
//        if (expressionComparator(
//                calculateLeft.second,
//                calculateRight.second,
//                comparator
//            )
//        ) {
//            connectBlocks(this, begin, false)
//        } else {
//            connectBlocks(this, exit, false)
//        }
//    }
//}
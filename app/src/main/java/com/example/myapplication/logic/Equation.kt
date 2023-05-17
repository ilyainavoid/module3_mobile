package com.example.myapplication.logic

class Equation: Block() {
    private var inputValue: String= ""
    private var inputVariable: String = ""
    private var value:Int = 0
    private var variable:String = ""

    init {
        type = "Equation"
    }

    override fun initVariables() {
        inputVariable = inputEditLeft
        inputValue = inputEditRight
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()
        val calculated = calculate(container, inputValue)
        status = calculated.first
        container.setVariableValue(variable, value)
    }
}
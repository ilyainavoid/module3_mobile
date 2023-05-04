package com.example.myapplication.logic

class DefiniedVar : Block() {

    private var value : Int = 0
    private var variale : String = ""
    private var inputValue: String =""
    private var inputVariable: String =""
    init {
        type = "DefinedVariable"
    }

    override fun initVariables() {
        inputVariable = inputEditLeft
        inputValue = inputEditRight
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()

        val calculated = calculate(container, inputValue)
        variale = inputVariable
        if (calculated.first == OK()) {
            value = calculated.second
            container.setVariableValue(variale, value)
        }
    }

}
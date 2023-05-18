package com.example.myapplication.logic

class DefiniedVar : Block() {

    var value : Int = 0
    var variable : String = ""
    var inputValue: String =""
    var inputVariable: String =""
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
        variable = inputVariable
        if (calculated.first == OK()) {
            value = calculated.second
            container.setVariableValue(variable, value)
        }
    }

}
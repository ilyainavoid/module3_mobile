package com.example.myapplication.logic

class Equation : Block() {
    private var inputValue: String = ""
    private var inputVariable: String = ""
    var value: Int = 0
    private var variable: String = ""

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
        val obj = defineInput(container, inputVariable)
        variable = obj.second
        if (obj.first !in listOf(tagArray(), tagVariable())) {
            status = obj.first
            return
        }
        val calculated = calculate(container, inputValue)
        status = calculated.first
        if (calculated.first != OK()) return
        value = calculated.second
        when (obj.first) {
            tagArray() -> {
                container.setArrayValue(variable, obj.third, value)
            }

            tagVariable() -> {
                container.setVariableValue(variable, value)
            }
        }
    }
}
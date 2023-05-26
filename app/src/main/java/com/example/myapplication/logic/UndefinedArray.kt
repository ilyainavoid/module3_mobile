package com.example.myapplication.logic

class UndefinedArray : Block() {
    var size: Int = 0
    var name: String = ""
    private var inputSize: String = ""
    private var inputName: String = ""

    init {
        type = "UndefinedArray"
    }

    override fun initVariables() {
        inputName = inputEditLeft
        inputSize = inputEditRight
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()
        val calcSize = calculate(container, inputSize)

        if (!variableCheck(inputName)) {
            status = incorrectNaming(inputName)
            return
        }
        if (calcSize.first != OK() || calcSize.second < 1) {
            status = incorrectSize(inputSize)
            return
        }
        if (container.isVariableExist(inputName)) {
            status = typeMismatchVariable(inputName)
            return
        }
        name = inputName
        size = calcSize.second
        container.createArray(name, size)
        for (i in 0 until size) {
            container.setArrayValue(name, i, 0)
        }
    }
}

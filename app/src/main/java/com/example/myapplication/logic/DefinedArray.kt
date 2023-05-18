package com.example.myapplication.logic

class DefinedArray: Block() {
    private var size: Int = 0
    private var name: String = ""
    private var values: String = ""
    private var inputSize: String = ""
    private var inputValues: String = ""
    private var inputName: String = ""

    init {
        type = "DefinedArray"
    }
    override fun initVariables() {
        inputName = inputEditLeft
        inputSize = inputEditMiddle
        inputValues = inputEditRight
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
        values = inputValues
        container.createArray(name, size)
        val valuesList = toVarList(values)
        if (valuesList.size != size) {
            status = mismatchSize()
            return
        }

        for (i in valuesList.indices) {
            val calcValue = calculate(container, valuesList[i])
            if (calcValue.first != OK()) {
                status = incorrectValue(valuesList[i])
                return
            }
            container.setArrayValue(name, i, calcValue.second)
        }
    }
}
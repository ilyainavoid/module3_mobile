package com.example.myapplication.logic

class UndefinedArray : Block() {
    private var inputNames: List<String> = listOf()

    init {
        type = "UndefinedVariable"
    }

    override fun initVariables() {
        inputNames = toVarList(inputEditLeft)
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()
        var flag = true
        for (el in inputNames) {
            if (!variableCheck(el)) {
                status = incorrectNaming(el)
                flag = false
            }
            if (container.isArrayExist(el)) {
                //status = typeMismatchArray(el)
                flag = false
            }
        }
        if (flag) container.setNullVars(inputNames)
    }
}

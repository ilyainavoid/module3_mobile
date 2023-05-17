package com.example.myapplication.logic

class UndefiniedVariable: Block() {
    private var variables: List<String> = listOf()
    init{
        type = "UndefiinedVariable"
    }

    override fun initVariables() {
        variables = toVarList(inputEditLeft)
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()
        var flag = true
        for (variable in variables){
            if (!variableCheck(variable)){
                flag = false
            }
        }
        if (flag){
            container.setNullVars(variables)
        }
    }
}
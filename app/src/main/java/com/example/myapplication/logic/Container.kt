package com.example.myapplication.logic

class Container {
    private var container: MutableMap<String, Int> = mutableMapOf()

    fun createVariables(variables: List<String>){
        for(variable: String in variables) container[variable] = 0
    }
    fun setVariableValue(variable: String, value: Int){
        container[variable] = value
    }
    fun getVariableValue(variable:String): Int?{
        return container[variable]
    }
    fun isVariableExist(variable: String) :Boolean{
        return variable in container.keys
    }
    fun deleteVariable(variable: String){
        container.remove(variable)
    }

    fun clearContainer(){
        container.clear()
    }
    fun setNullVars(variables: List<String>){
        for (variable: String in variables){
            container[variable] = 0
        }
    }
}
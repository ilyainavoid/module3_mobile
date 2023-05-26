package com.example.myapplication.logic

class Container {
    private var container: MutableMap<String, Int> = mutableMapOf()
    private var containerArray: MutableMap<String, Array<Int>> = mutableMapOf()
    fun createVariables(variables: List<String>) {
        for (variable: String in variables) container[variable] = 0
    }

    fun setVariableValue(variable: String, value: Int) {
        container[variable] = value
    }

    fun getVariableValue(variable: String): Int? {
        return container[variable]
    }

    fun isVariableExist(variable: String): Boolean {
        return variable in container.keys
    }

    fun deleteVariable(variable: String) {
        container.remove(variable)
    }

    fun clearContainer() {
        container.clear()
        containerArray.clear()
    }

    fun setNullVars(variables: List<String>) {
        for (variable: String in variables) {
            container[variable] = 0
        }
    }

    fun createArray(arrayName: String, arraySize: Int) {
        containerArray[arrayName] = Array(arraySize) { 0 }
    }

    fun deleteArray(arrayName: String) {
        containerArray.remove(arrayName)
    }

    fun setArrayValue(arrayName: String, index: Int, value: Int) {
        containerArray[arrayName]?.set(index, value)
    }

    fun getArrayValue(arrayName: String, index: Int): Int? {
        return containerArray[arrayName]?.get(index)
    }

    fun getArray(arrayName: String): Array<Int>? {
        return containerArray[arrayName]
    }

    fun isArrayExist(arrayName: String): Boolean {
        return arrayName in containerArray.keys
    }

    fun getArraysList(): MutableSet<String> {
        return containerArray.keys
    }

    fun getArraySize(arrayName: String): Int? {
        return containerArray[arrayName]?.size
    }

    fun clearArrays() {
        containerArray.clear()
    }
}
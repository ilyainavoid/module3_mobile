package com.example.myapplication.logic

import com.example.myapplication.navigation.Console.adapterConsole

class OutputBlock : Block() {
    private var message: String = ""
    private var expression: String = ""

    init {
        type = "Output"
    }

    override fun initVariables() {
        message = if (inputEditLeft == "") "" else inputEditLeft
        expression = inputEditRight
    }

    override fun runBlock() {
        super.runBlock()
        initVariables()
        if (expression == "") {
            adapterConsole.addMessage(message)
        }
        if (container.isArrayExist(expression)) {
            adapterConsole.addMessage("$message[${container.getArray(expression)?.joinToString()}]")
            return
        }
        val calculated = calculate(container, expression)
        status = calculated.first
        if (status != OK()) return
        adapterConsole.addMessage("$message${calculated.second}")
    }
}
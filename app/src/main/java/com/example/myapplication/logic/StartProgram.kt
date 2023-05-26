package com.example.myapplication.logic

class StartProgram : Block() {
    init {
        type = "EntryPoint"
    }

    override fun run() {
        container.clearContainer()
        container.clearArrays()
    }

    override fun kickRunning() {
        super.kickRunning()

        if (!isWorking) return
        if (blockStack.empty()) return
        blockStack.pop().run()
    }
}
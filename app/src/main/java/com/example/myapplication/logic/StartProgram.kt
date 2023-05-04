package com.example.myapplication.logic

class StartProgram:Block() {
    init {
        type = "EntryPoint"
    }

    override fun run() {

        container.clearContainer()
        container.clearContainer()
    }

    override fun kickRunning() {
        super.kickRunning()

        if (!isWorking) return
        if (blockStack.empty()) return
        blockStack.pop().run()
    }
}
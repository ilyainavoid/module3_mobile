package com.example.myapplication.logic

import androidx.compose.runtime.mutableStateListOf

class ConsoleAdapter() {
    var outputMessageList = mutableStateListOf<String>()

    fun addMessage(message: String) {
        outputMessageList.add(message)
    }

    fun clearMessageList() {
        val size = outputMessageList.size
        if (size > 0) {
            for (i in 0 until size) {
                outputMessageList.removeAt(0)
            }
        }
    }
}
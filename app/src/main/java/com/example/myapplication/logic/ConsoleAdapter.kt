package com.example.myapplication.logic

class ConsoleAdapter(){
    var outputMessageList = ArrayList<String>()

    fun addMessage(message: String){
        outputMessageList.add(message)
    }

    fun clearMessageList(){
        val size = outputMessageList.size
        if (size > 0 ){
            for(i in 0 until size){
                outputMessageList.removeAt(0)
            }
        }
    }
}
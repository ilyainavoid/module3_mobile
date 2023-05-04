package com.example.myapplication.logic



fun variableCheck(variable: String): Boolean {
    val str = variable.replace("[A-Za-z0-9_]".toRegex(), "")
    if (str.isNotEmpty()) {
        return false
    }
    return true
}
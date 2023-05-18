package com.example.myapplication.logic

fun variableCheck(variable: String): Boolean {
    val str = variable.replace("[A-Za-z0-9_]".toRegex(), "")
    if (str.isNotEmpty()) {
        return false
    }
    return true
}

fun toVarList(vars: String): List<String>{
    return vars.replace("[\\s*]".toRegex(), "")
        .replace("[,;]".toRegex(), " ")
        .split("[\\s*]".toRegex()).filter { it.isNotEmpty() }
}

fun expressionComparator(numberLeft: Int, numberRight: Int, comparator: String): Boolean {
    when (comparator) {
        ">" -> return (numberLeft > numberRight)
        ">=" -> return (numberLeft >= numberRight)
        "<" -> return (numberLeft < numberRight)
        "<=" -> return (numberLeft <= numberRight)
        "==" -> return (numberLeft == numberRight)
        "!=" -> return (numberLeft != numberRight)
    }
    return false
}
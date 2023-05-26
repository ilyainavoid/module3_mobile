package com.example.myapplication.logic

val OK = fun(): String { return "OK" }
val invalidComparator = fun(): String { return "Invalid comparator" }
val divisionByZero = fun(): String { return "Division by zero" }
val incorrectExpression = fun(): String { return "Incorrect expression" }
val incorrectNaming = fun(name: String): String { return "Incorrect naming '$name'" }
val incorrectSize = fun(size: String): String { return "Incorrect size '$size'" }
val unexpectedSymbol = fun(operand: String): String { return "Unexpected symbol '$operand'" }
val allComparators = listOf(">", ">=", "<", "<=", "==", "!=")
val inputError = fun(): String { return "InputError" }
val mismatchSize = fun(): String { return "Sizes mismatch" }
val typeMismatchVariable =
    fun(name: String): String { return "Type mismatch, $name is an existing variable" }
val incorrectValue = fun(value: String): String { return "Incorrect value '$value'" }
val emptyInput = fun(): String { return "Empty Input" }
val undefinedArray = fun(arrayName: String): String { return "Undefined array '$arrayName'" }
val indexOutOfRange = fun(): String { return "Index out of range" }
val tagNothing = fun(): String { return "Nothing" }
val tagVariable = fun(): String { return "Variable" }
val tagArray = fun(): String { return "Array" }
val undefinedVariable =
    fun(variableValue: String): String { return "Undefined variable '$variableValue'" }
val typeMismatchArray =
    fun(name: String): String { return "Type mismatch, $name is an existing array" }
val programFinish = fun(status: String): String { return "Program finished with status: $status" }
val programStart = fun(): String { return "Program started" }
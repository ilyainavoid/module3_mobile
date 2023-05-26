package com.example.myapplication.logic

var OK = fun(): String { return "OK" }

var invalidComparator = fun(): String { return "Invalid comparator" }
var divisionByZero = fun(): String { return "Division by zero" }
var incorrectExpression = fun(): String { return "Incorrect expression" }
var incorrectNaming = fun(name: String): String { return "Incorrect naming '$name'" }
var incorrectSize = fun(size: String): String { return "Incorrect size '$size'" }
var unexpectedSymbol = fun(operand: String): String { return "Unexpected symbol '$operand'" }
var allComparators = listOf(">", ">=", "<", "<=", "==", "!=")
var inputError = fun(): String { return "InputError" }
var mismatchSize = fun(): String { return "Sizes mismatch" }
var typeMismatchVariable =
    fun(name: String): String { return "Type mismatch, $name is an existing variable" }
var incorrectValue = fun(value: String): String { return "Incorrect value '$value'" }
var emptyInput = fun(): String { return "Empty Input" }
var undefinedArray = fun(arrayName: String): String { return "Undefined array '$arrayName'" }
var indexOutOfRange = fun(): String { return "Index out of range" }
var tagNothing = fun(): String { return "Nothing" }
var tagVariable = fun(): String { return "Variable" }
var tagArray = fun(): String { return "Array" }
var undefinedVariable =
    fun(variableValue: String): String { return "Undefined variable '$variableValue'" }
var typeMismatchArray =
    fun(name: String): String { return "Type mismatch, $name is an existing array" }
var programFinish = fun(status: String): String { return "Program finished with status: $status" }
var programStart = fun(): String { return "Program started" }
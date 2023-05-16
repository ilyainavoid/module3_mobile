package com.example.myapplication.logic

var OK = fun(): String { return "OK" }

var divisionByZero = fun(): String { return "Division by zero" }
var incorrectExpression = fun(): String { return "Incorrect expression" }
var incorrectNaming = fun(name: String): String { return "Incorrect naming '$name'" }
var unexpectedSymbol = fun(operand: String): String { return "Unexpected symbol '$operand'" }
var inputError = fun(): String { return "InputError" }
package com.example.myapplication.logic

import com.example.myapplication.navigation.CodeEditor.controller
import com.example.myapplication.navigation.Console.adapterConsole

fun connectionInBlock(index: Int): Pair<Int, Int> {
    var i = index
    while (controller.blockList[i + 1].type != "End") {
        if (i + 1 == controller.blockList.size) {
            adapterConsole.addMessage("В строке $i ожидался End")
            return Pair(0, 0)
        }
        if (controller.blockList[i].type == "ConditionIf" ||
            controller.blockList[i].type == "ConditionIfElse" ||
            controller.blockList[i].type == "CycleWhile" ||
            controller.blockList[i].type == "For Cycle"
        ) {
            val temp = if (controller.blockList[i].type == "ConditionIfElse")
                connectionIfElse(i)
            else
                connectionIfOrWhile(i)

            if (temp == 0)
                return Pair(0, 0)
            else {
                if (temp < controller.blockList.size && controller.blockList[temp].type != "End") {
                    connectBlocks(controller.blockList[i], controller.blockList[temp])
                    i = temp
                } else if (temp < controller.blockList.size && controller.blockList[temp].type == "End") {
                    return Pair(i, temp)
                } else if (temp >= controller.blockList.size) {
                    adapterConsole.addMessage("В строке $temp ожидался End")
                    return Pair(0, 0)
                } else
                    break
            }
        } else {
            connectBlocks(controller.blockList[i], controller.blockList[i + 1])
            i += 1
        }
    }
    return Pair(i, 0)
}

fun connectionIfElse(index: Int): Int {
    var i = index + 1
    if (controller.blockList[i].type == "Begin") {
        i += 1
        if (controller.blockList[i].type != "End") {
            connectBlocks(controller.blockList[index].begin, controller.blockList[i])
            val (j, temp) = connectionInBlock(i)
            if (j == 0)
                return 0
            else if (controller.blockList[temp].type == "End") {
                connectBlocks(controller.blockList[j], controller.blockList[index].end)
                i = temp + 1
            } else {
                connectBlocks(controller.blockList[j], controller.blockList[index].end)
                i = j + 2
            }
        } else {
            connectBlocks(controller.blockList[index].begin, controller.blockList[index].end)
            i += 1
        }
        if (controller.blockList[i].type == "Else") {
            i += 1
            if (controller.blockList[i].type == "Begin") {
                i += 1
                if (controller.blockList[i].type != "End") {
                    connectBlocks(controller.blockList[index].beginElse, controller.blockList[i])
                    val (i, temp) = connectionInBlock(i)
                    if (i == 0)
                        return 0
                    else if (controller.blockList[temp].type == "End") {
                        connectBlocks(controller.blockList[i], controller.blockList[index].end)
                        return temp + 1
                    }
                    connectBlocks(controller.blockList[i], controller.blockList[index].endElse)
                    return i + 2
                } else
                    connectBlocks(
                        controller.blockList[index].beginElse,
                        controller.blockList[index].endElse
                    )
                return i + 1
            } else {
                adapterConsole.addMessage("В строке $i ожидался Begin")
                return 0
            }
        } else {
            adapterConsole.addMessage("В строке $i ожидался Else")
            return 0
        }
    } else {
        adapterConsole.addMessage("В строке $i ожидался Begin")
        return 0
    }
}

fun connectionIfOrWhile(index: Int): Int {
    var i = index + 1
    if (controller.blockList[i].type == "Begin") {
        i += 1
        if (controller.blockList[i].type == "End") {
            connectBlocks(controller.blockList[index].begin, controller.blockList[index].end)
            return i + 1
        }
        connectBlocks(controller.blockList[index].begin, controller.blockList[i])
        val (i, temp) = connectionInBlock(i)
        if (i == 0)
            return 0
        else if (controller.blockList[temp].type == "End") {
            connectBlocks(controller.blockList[i], controller.blockList[index].end)
            return temp + 1
        }
        connectBlocks(controller.blockList[i], controller.blockList[index].end)
        return i + 2
    } else {
        adapterConsole.addMessage("В строке $i ожидался Begin")
        return 0
    }
}

fun connectionBlocks(): Boolean {
    var i = 0
    while (i < controller.blockList.size - 1) {
        if (controller.blockList[i].type == "Begin") {
            adapterConsole.addMessage("Обнаружен не к месту Begin в строке $i")
            return false
        } else if (controller.blockList[i].type == "End") {
            adapterConsole.addMessage("Обнаружен не к месту End в строке $i")
            return false
        } else if (controller.blockList[i].type == "Else") {
            adapterConsole.addMessage("Обнаружен не к месту Else в строке $i")
            return false
        } else if (controller.blockList[i].type == "ConditionIf" ||
            controller.blockList[i].type == "ConditionIfElse" ||
            controller.blockList[i].type == "CycleWhile"
        ) {

            val temp = if (controller.blockList[i].type == "ConditionIfElse")
                connectionIfElse(i)
            else
                connectionIfOrWhile(i)

            if (temp == 0) return false
            else {
                if (temp < controller.blockList.size) {
                    connectBlocks(controller.blockList[i], controller.blockList[temp])
                    i = temp
                } else
                    break
            }
        } else {
            connectBlocks(controller.blockList[i], controller.blockList[i + 1])
            i += 1
        }
    }
    return true
}
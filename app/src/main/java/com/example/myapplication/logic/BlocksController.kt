package com.example.myapplication.logic

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow

class BlocksController {

    private val startingBlock = StartProgram()

    var blockList = mutableStateListOf<Block>()
    val containerStorage = Container()

    init {
        blockList.add(startingBlock)
    }

    fun addBlock(newBlock: Block) {
        blockList.add(newBlock)
    }

}
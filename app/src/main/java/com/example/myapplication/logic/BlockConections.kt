package com.example.myapplication.logic

fun connectBlocks(firstBlock: Block, secondBlock:Block, clear: Boolean = true){
    if(firstBlock == secondBlock)return
    if (clear){
        firstBlock.nextBlock?.prevBlock = null
        secondBlock.prevBlock?.nextBlock = null
    }
    firstBlock.nextBlock = secondBlock
    secondBlock.prevBlock = firstBlock
}

fun disconnectBlocks(firstBlock: Block, secondBlock: Block){
    firstBlock.nextBlock = null
    secondBlock.prevBlock = null
}
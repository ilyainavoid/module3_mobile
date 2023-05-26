package com.example.myapplication.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.example.myapplication.blockAppearance.BlockItem
import com.example.myapplication.logic.Begin
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.BlocksController
import com.example.myapplication.logic.ConditionIf
import com.example.myapplication.logic.DefinedArray
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.End
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.ForCycle
import com.example.myapplication.logic.OK
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.StartProgram
import com.example.myapplication.logic.UndefinedArray
import com.example.myapplication.logic.UndefiniedVariable
import com.example.myapplication.logic.WhileCycle
import com.example.myapplication.logic.disconnectBlocks
import com.example.myapplication.logic.runProgram
import com.example.myapplication.navigation.CodeEditor.controller
import com.example.myapplication.navigation.Console.adapterConsole
import org.burnoutcrew.reorderable.ReorderableItem
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyListState
import org.burnoutcrew.reorderable.reorderable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Tab.TabContent() {
    when (options.title) {
        "CodeEditor" -> {
            CodeEditorContent()
        }

        "Console" -> {
            ConsoleContent()
        }

        "BlockCreationMenu" -> {
            BlockCreationMenuContent()
        }
    }
}

@Composable
fun BlockCreationMenuContent() {
    var newBlock: Block

    val catalog = listOf(
        "Defined variable",
        "Undefined variable",
        "Reassignment",
        "Condition If",
        "While Cycle",
        "Output",
        "Defined array",
        "Undefined array",
        "Condition If Else",
        "For cycle",
        "Exit"
    )
    val context = LocalContext.current
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(catalog) { index, item ->
            Button(
                onClick = {
                    Toast.makeText(context, "Block created!", Toast.LENGTH_SHORT).show()
                    when (item) {
                        "Defined variable" -> {
                            newBlock = DefiniedVar()
                            controller.blockList.add(newBlock)
                        }

                        "Undefined variable" -> {
                            newBlock = UndefiniedVariable()
                            controller.blockList.add(newBlock)
                        }

                        "Reassignment" -> {
                            newBlock = Equation()
                            controller.blockList.add(newBlock)
                        }

                        "Condition If" -> {
                            newBlock = ConditionIf()
                            controller.blockList.add(newBlock)
                            newBlock = Begin()
                            controller.blockList.add(newBlock)
                            newBlock = End()
                            controller.blockList.add(newBlock)
                        }

                        "While Cycle" -> {
                            newBlock = WhileCycle()
                            controller.blockList.add(newBlock)
                            newBlock = Begin()
                            controller.blockList.add(newBlock)
                            newBlock = End()
                            controller.blockList.add(newBlock)
                        }

                        "Output" -> {
                            newBlock = OutputBlock()
                            controller.blockList.add(newBlock)
                        }

                        "Defined array" -> {
                            newBlock = DefinedArray()
                            controller.blockList.add(newBlock)
                        }

                        "Undefined array" -> {
                            newBlock = UndefinedArray()
                            controller.blockList.add(newBlock)
                        }

                        "Condition If Else" -> {
                            newBlock = ConditionIf()
                            controller.blockList.add(newBlock)
                            newBlock = Begin()
                            controller.blockList.add(newBlock)
                            newBlock = End()
                            controller.blockList.add(newBlock)
                        }

                        "For cycle" -> {
                            newBlock = ForCycle()
                            controller.blockList.add(newBlock)
                            newBlock = Begin()
                            controller.blockList.add(newBlock)
                            newBlock = End()
                            controller.blockList.add(newBlock)
                        }

                        "End" -> {
                            newBlock = End()
                            controller.blockList.add(newBlock)
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(10.dp)
            ) {
                Text(item, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun CodeEditorContent() {
    val context = LocalContext.current
    val state = rememberReorderableLazyListState(onMove = { from, to ->
        controller.blockList = controller.blockList.apply {
            add(to.index, removeAt(from.index))
        }
    })
    val blocksDeleted = remember { mutableStateOf(false) }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state.listState,
        modifier = Modifier
            .fillMaxSize()
            .reorderable(state)
            .detectReorderAfterLongPress(state)
    ) {
        itemsIndexed(controller.blockList) { index, item ->
            ReorderableItem(state, key = item) {
                isDragging ->
                val elevation = animateDpAsState(if (isDragging) 30.dp else 0.dp)
                Column(
                    modifier = Modifier
                        .shadow(elevation.value)
                ) {
                    BlockItem(item)
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .padding(15.dp), contentAlignment = Alignment.BottomEnd
    ) {
        IconButton(
            onClick = {
                Toast.makeText(context, "Blocks have been deleted!", Toast.LENGTH_SHORT)
                    .show()
                controller.containerStorage.clearContainer()
                controller.blockList.clear()
                val block = StartProgram()
                controller.blockList.add(block)
                blocksDeleted.value = true

            },
            modifier = Modifier
                .then(Modifier.size(40.dp)),
        ) {
            Icon(
                Icons.Default.Delete,
                contentDescription = "content description",
                tint = Color.Magenta
            )
        }
    }
}

@Composable
fun ConsoleContent() {
    val context = LocalContext.current
    LazyColumn() {
        itemsIndexed(adapterConsole.outputMessageList) { index, item ->
            Text(
                ">>> $item",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                color = Color.Green
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
            .padding(15.dp), contentAlignment = Alignment.BottomEnd
    ) {
        IconButton(
            onClick = {
                Toast.makeText(context, "Program Started!", Toast.LENGTH_SHORT).show()
                runProgram()
            },
            modifier = Modifier
                .then(Modifier.size(40.dp))
        ) {
            Icon(
                Icons.Default.PlayArrow,
                contentDescription = "content description",
                tint = Color.Green
            )
        }
    }
}
package com.example.myapplication.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.BlocksController
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.UndefiniedVariable
import com.example.myapplication.navigation.CodeEditor.controller
import com.example.myapplication.navigation.Console.adapterConsole

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Tab.TabContent() {
    var newBlock: Block

    val catalog = listOf("Defined variable", "Undefined variable", "Reassignment", "Condition If",
    "While cycle", "Output", "Defined array", "Undefined array", "Condition If Else", "For cycle")

    when(options.title) {
        "CodeEditor" -> {
            val context = LocalContext.current
            val blocksDeleted = remember { mutableStateOf(false) }
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {
                itemsIndexed(controller.blockList) {
                    index, item ->
                    BlockItem(item)
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .padding(15.dp), contentAlignment = Alignment.BottomEnd) {
                IconButton(onClick = {
                    Toast.makeText(context, "Blocks have been deleted!", Toast.LENGTH_SHORT).show()
                    controller.blockList.clear()
                    blocksDeleted.value = true
                },
                    modifier = Modifier
                        .then(Modifier.size(40.dp)),
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "content description", tint = Color.Magenta)
                }
            }
        }
        "Console" -> {
            val context = LocalContext.current
            LazyColumn(){itemsIndexed(adapterConsole.outputMessageList){
                index, item ->
                    Text(
                        ">>> $item",
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        color = Color.Green
                    )
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .padding(15.dp), contentAlignment = Alignment.BottomEnd) {
                IconButton(onClick = {
                    Toast.makeText(context, "Program Started!", Toast.LENGTH_SHORT).show()
                },
                    modifier = Modifier
                        .then(Modifier.size(40.dp))
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "content description", tint = Color.Green)
                }
            }
        }
        "BlockCreationMenu" -> {
            val context = LocalContext.current
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(catalog) {
                    index, item ->
                    Button(onClick = {
                        Toast.makeText(context, "Block created!", Toast.LENGTH_SHORT).show()
                        when(item) {
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
//                                newBlock = ConditionIf()
//                                blocksList.add(newBlock)
                            }
                            "While cycle" -> {
//                                newBlock = ()
//                                blocksList.add(newBlock)
                            }
                            "Output" -> {
                                newBlock = OutputBlock()
                                controller.blockList.add(newBlock)
                            }
                            "Defined array" -> {
//                                newBlock = ()
//                                blocksList.add(newBlock)
                            }
                            "Undefined array" -> {
//                                newBlock = ()
//                                blocksList.add(newBlock)
                            }
                            "Condition If Else" -> {
//                                newBlock = ()
//                                blocksList.add(newBlock)
                            }
                            "For cycle" -> {
//                                newBlock = ()
//                                blocksList.add(newBlock)
                            }
                        }
                    }, modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(10.dp)) {
                        Text(item, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}


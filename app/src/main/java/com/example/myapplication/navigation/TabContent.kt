package com.example.myapplication.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.myapplication.logic.UndefiniedVariable
import com.example.myapplication.navigation.CodeEditor.blocksList

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Tab.TabContent() {
    var newBlock: Block

    val catalog = listOf("Defined variable", "Undefined variable", "Reassignment", "Condition If",
    "While cycle", "Output", "Defined array", "Undefined array", "Condition If Else", "For cycle")

    when(options.title) {
        "CodeEditor" -> {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {
                itemsIndexed(blocksList) {
                    index, item ->
                    BlockItem(item)
                }
            }
        }
        "Console" -> {
            Text("This is console")
        }
        "BlockCreationMenu" -> {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(catalog) {
                    index, item ->
                    Button(onClick = {
                        when(item) {
                            "Defined variable" -> {
                                newBlock = DefiniedVar()
                                blocksList.add(newBlock)
                            }
                            "Undefined variable" -> {
                                newBlock = UndefiniedVariable()
                                blocksList.add(newBlock)
                            }
                            "Reassignment" -> {
                                newBlock = Equation()
                                blocksList.add(newBlock)
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
//                                newBlock = ()
//                                blocksList.add(newBlock)
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


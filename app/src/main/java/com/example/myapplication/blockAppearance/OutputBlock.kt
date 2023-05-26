package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.runProgram
import com.example.myapplication.navigation.CodeEditor.controller
import com.example.myapplication.navigation.Console.adapterConsole

@Composable
fun DrawOutputBlock(block: OutputBlock) {
    val message = remember { mutableStateOf(block.inputEditLeft) }
    val variables = remember { mutableStateOf(block.inputEditRight) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.DarkGray),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.4f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column() {
                            Text(
                                "Message",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(1f)
                            )
                            TextField(
                                value = message.value,
                                onValueChange = {
                                    message.value = it
                                },
                                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .padding(10.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column() {
                            Text(
                                "Variable",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(1f)
                            )
                            TextField(
                                value = variables.value,
                                onValueChange = {
                                    variables.value = it
                                },
                                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .padding(10.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .background(Color.Blue),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {
                            block.inputEditLeft = message.value
                            block.inputEditRight = variables.value
                        }) {
                            Icon(
                                Icons.Outlined.Done,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
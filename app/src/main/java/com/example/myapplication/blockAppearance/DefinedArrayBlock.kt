package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Settings
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.DefinedArray
import com.example.myapplication.navigation.CodeEditor

@Composable
fun DrawDefinedArrayBlock(block: DefinedArray) {
    val showExtendView = remember { mutableStateOf(false) }

    val arrayName = remember { mutableStateOf(block.inputEditLeft) }
    val arraySize = remember { mutableStateOf(block.inputEditMiddle) }
    val arrayValues = remember { mutableStateOf(block.inputEditRight) }
    if (arrayName.value == "" && arraySize.value == "" && arrayValues.value == "") {
        showExtendView.value = true
    }

    if (!showExtendView.value) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray), contentAlignment = Alignment.Center
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.fillMaxWidth(.9f)) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(.3f), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "arr",
                                    fontStyle = FontStyle(0),
                                    color = Color.White,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(), contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    "${arrayName.value}[ ](${arraySize.value})",
                                    fontStyle = FontStyle(0),
                                    color = Color.White,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }

                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "values: ${arrayValues.value}",
                                    fontStyle = FontStyle(0),
                                    color = Color.White,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {
                            CodeEditor.controller.containerStorage.deleteArray(block.name)
                            showExtendView.value = true
                        }) {
                            Icon(
                                Icons.Outlined.Settings,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    } else {
        DrawExtendedDefinedArrayBlock(block)
    }
}

@Composable
fun DrawExtendedDefinedArrayBlock(block: DefinedArray) {
    val arrayName = remember { mutableStateOf(block.inputEditLeft) }
    val arraySize = remember { mutableStateOf(block.inputEditRight) }
    val arrayValues = remember { mutableStateOf(block.inputEditRight) }
    val showExtendView = remember { mutableStateOf(true) }

    if (showExtendView.value) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray), contentAlignment = Alignment.Center
            ) {
                Row() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.875f), contentAlignment = Alignment.Center
                    ) {
                        Column() {
                            Box() {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "array_name [ ] (size)",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                    }

                                }
                            }
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Row() {
                                    Column(modifier = Modifier.fillMaxWidth(.5f)) {
                                        Text(
                                            "Input name:",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                        TextField(
                                            value = arrayName.value,
                                            onValueChange = {
                                                arrayName.value = it
                                            },
                                            textStyle = TextStyle(
                                                color = Color.Black,
                                                fontSize = 20.sp
                                            ),
                                            modifier = Modifier
                                                .background(Color.DarkGray)
                                                .padding(10.dp)
                                        )
                                    }
                                    Column() {
                                        Text(
                                            "Input size:",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                        TextField(
                                            value = arraySize.value,
                                            onValueChange = {
                                                arraySize.value = it
                                            },
                                            textStyle = TextStyle(
                                                color = Color.Black,
                                                fontSize = 20.sp
                                            ),
                                            modifier = Modifier
                                                .background(Color.DarkGray)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                            }
                            Box() {
                                Row() {
                                    Text(
                                        "Input values:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = arrayValues.value,
                                        onValueChange = {
                                            arrayValues.value = it
                                        },
                                        textStyle = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        modifier = Modifier
                                            .background(Color.DarkGray)
                                            .padding(10.dp)
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {
                            block.inputEditLeft = arrayName.value
                            block.inputEditMiddle = arraySize.value
                            block.inputEditRight = arrayValues.value
                            //block.runBlock()
                            showExtendView.value = false
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
    } else {
        DrawDefinedArrayBlock(block)
    }
}


@Preview
@Composable
fun DrawDefinedArray() {
    DrawDefinedArrayBlock(block = DefinedArray())
}
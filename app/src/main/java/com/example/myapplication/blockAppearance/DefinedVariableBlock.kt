package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.DefiniedVar

@Composable
fun DefinedVariableBlockAppearance(block: DefiniedVar) {
    var showExtendView = remember { mutableStateOf(false) }

    var variableName = block.variable
    var value = block.value

    if (variableName == "" && value == 0) {
        showExtendView.value = true
    }

    if (showExtendView.value == false) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier
                        .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd) {
                        Text("VariableName", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth(.1f), contentAlignment = Alignment.Center) {
                        Text("=", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth(.8f), contentAlignment = Alignment.CenterStart) {
                        Text("VariableValue", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth(1f), contentAlignment = Alignment.Center) {
                        IconButton(onClick = { showExtendView.value = true }) {
                            Icon(Icons.Outlined.Settings, contentDescription = "Информация о приложении", modifier = Modifier.size(20.dp), tint = Color.White)
                        }
                    }
                }
            }
        }
    }
    else {
        ExtendedDefinedVariableBlockAppearance(block)
    }
}

@Composable
fun ExtendedDefinedVariableBlockAppearance(block: DefiniedVar) {

    var variableName = block.variable
    var value = block.value

    var showExtendView = remember { mutableStateOf(true) }

    if (showExtendView.value == true) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray), contentAlignment = Alignment.Center) {
                Row() {
                    Box(modifier = Modifier
                        .fillMaxWidth(0.875f), contentAlignment = Alignment.Center) {
                        Column() {
                            Box() {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(modifier = Modifier
                                        .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd) {
                                        Text("VariableName", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                    }
                                    Box(modifier = Modifier
                                        .fillMaxWidth(.1f), contentAlignment = Alignment.Center) {
                                        Text("=", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                    }
                                    Box(modifier = Modifier
                                        .fillMaxWidth(.8f), contentAlignment = Alignment.CenterStart) {
                                        Text("VariableValue", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                    }
                                }
                            }
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                                Row() {
                                    Text("Input name:", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                    val textState = remember { mutableStateOf("") }
                                    TextField(
                                        value = textState.value,
                                        onValueChange = {
                                            textState.value = it
                                        },
                                        textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                        modifier = Modifier.background(Color.DarkGray)
                                    )
                                }
                            }
                            Box() {
                                Row() {
                                    Text("Input value:", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                    val textState = remember { mutableStateOf("") }
                                    TextField(
                                        value = textState.value,
                                        onValueChange = {
                                            textState.value = it
                                        },
                                        textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                        modifier = Modifier.background(Color.DarkGray)
                                    )
                                }
                            }
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth(1f), contentAlignment = Alignment.Center) {
                        IconButton(onClick = { showExtendView.value = false }) {
                            Icon(Icons.Outlined.Done, contentDescription = "Информация о приложении", modifier = Modifier.size(20.dp), tint = Color.White)
                        }
                        Text(showExtendView.value.toString())
                    }
                }
            }
        }
    }
    else {
        DefinedVariableBlockAppearance(block)
    }
}

@Preview
@Composable
fun PreviewDefaultBlock() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray), contentAlignment = Alignment.Center) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier
                    .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd) {
                    Text("VariableName", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                }
                Box(modifier = Modifier
                    .fillMaxWidth(.1f), contentAlignment = Alignment.Center) {
                    Text("=", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                }
                Box(modifier = Modifier
                    .fillMaxWidth(.8f), contentAlignment = Alignment.CenterStart) {
                    Text("VariableValue", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                }
                Box(modifier = Modifier
                    .fillMaxWidth(1f), contentAlignment = Alignment.Center) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Settings, contentDescription = "Информация о приложении", modifier = Modifier.size(20.dp), tint = Color.White)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewExtendedBlock() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray), contentAlignment = Alignment.Center) {
            Row() {
                Box(modifier = Modifier
                    .fillMaxWidth(0.875f), contentAlignment = Alignment.Center) {
                    Column() {
                        Box() {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Box(modifier = Modifier
                                    .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd) {
                                    Text("VariableName", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                }
                                Box(modifier = Modifier
                                    .fillMaxWidth(.1f), contentAlignment = Alignment.Center) {
                                    Text("=", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                }
                                Box(modifier = Modifier
                                    .fillMaxWidth(.8f), contentAlignment = Alignment.CenterStart) {
                                    Text("VariableValue", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                }
                            }
                        }
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                            Row() {
                                Text("Input name:", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                val textState = remember { mutableStateOf("") }
                                TextField(
                                    value = textState.value,
                                    onValueChange = {
                                        textState.value = it
                                    },
                                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                    modifier = Modifier.background(Color.DarkGray)
                                )
                            }
                        }
                        Box() {
                            Row() {
                                Text("Input value:", fontStyle = FontStyle(0), color = Color.White, modifier = Modifier.padding(5.dp))
                                val textState = remember { mutableStateOf("") }
                                TextField(
                                    value = textState.value,
                                    onValueChange = {
                                        textState.value = it
                                    },
                                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                    modifier = Modifier.background(Color.DarkGray)
                                )
                            }
                        }
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth(1f), contentAlignment = Alignment.Center) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Done, contentDescription = "Информация о приложении", modifier = Modifier.size(20.dp), tint = Color.White)
                    }
                }
            }
        }
    }
}
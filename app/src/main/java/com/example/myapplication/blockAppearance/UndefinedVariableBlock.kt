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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.UndefiniedVariable

@Composable
fun DrawUndefinedVariableBlock(block: UndefiniedVariable) {
    val showExtendView = remember { mutableStateOf(false) }
    val variables = block.names

    if (block.names == "") {
        DrawExtendedUndefinedVariableBlock(block)
    } else {
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
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            variables,
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.1f), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "=",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.8f), contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            "0",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun DrawExtendedUndefinedVariableBlock(block: UndefiniedVariable) {
    val showExtendView = remember { mutableStateOf(true) }
    val variables = remember { mutableStateOf(block.names) }

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
                                            .fillMaxWidth(.3f),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text(
                                            variables.value,
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(.1f), contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "=",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(.8f),
                                        contentAlignment = Alignment.CenterStart
                                    ) {
                                        Text(
                                            "0",
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
                                    Text(
                                        "Input names:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = variables.value,
                                        onValueChange = {
                                            variables.value = it
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
                            block.names = variables.value
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
        DrawUndefinedVariableBlock(block)
    }
}


package com.example.myapplication.blockAppearance

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.ForCycle
import com.example.myapplication.logic.WhileCycle

@Composable
fun DrawForBlock(block: ForCycle) {
    val showExtendView = remember { mutableStateOf(false) }

    val varIterator = remember { mutableStateOf((block.valueVar)) }
    val equal = remember { mutableStateOf(block.inputEditLeft) }
    val step = remember { mutableStateOf(block.inputEditRight) }
    val compare = remember { mutableStateOf(block.inputEditMiddle) }
    val comparator = remember { mutableStateOf(block.inputComparator) }
    if (varIterator.value == "" && equal.value == "" && step.value == "" && compare.value == "") {
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
                    .background(Color(7, 18, 115)), contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.2f), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "For ",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.3f), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "${varIterator.value} = ${equal.value} ;",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.4f), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "${varIterator.value} ${comparator.value} ${compare.value} ;",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.8f), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "${varIterator.value} = ${step.value}",
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.CenterEnd
                    ) {
                        IconButton(onClick = {
                            showExtendView.value = true
                        }) {
                            Icon(
                                Icons.Outlined.Settings,
                                contentDescription = "Информация о приложении",
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    } else {
        DrawExtendedForBlock(block)
    }
}

@Composable
fun DrawExtendedForBlock(block: ForCycle) {
    val showExtendView = remember { mutableStateOf(true) }
    val varIterator = remember { mutableStateOf((block.valueVar)) }
    val equal = remember { mutableStateOf(block.inputEditLeft) }
    val step = remember { mutableStateOf(block.inputEditRight) }
    val compare = remember { mutableStateOf(block.inputEditMiddle) }
    val comparator = remember { mutableStateOf(block.inputComparator) }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }


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
                    .background(Color(7, 18, 115)), contentAlignment = Alignment.Center
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
                                            .fillMaxWidth(.4f),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text(
                                            "For it = ?; it ",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(.2f), contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            block.inputComparator,
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            " ?; it = it + ?",
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
                                            value = varIterator.value,
                                            onValueChange = {
                                                varIterator.value = it
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
                                            "${varIterator.value} equals to",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                        TextField(
                                            value = equal.value,
                                            onValueChange = {
                                                equal.value = it
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
                                    Column(modifier = Modifier.fillMaxWidth(.5f)) {
                                        Text(
                                            "compared with",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                        TextField(
                                            value = compare.value,
                                            onValueChange = {
                                                compare.value = it
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
                                            "with step",
                                            fontStyle = FontStyle(0),
                                            color = Color.White,
                                            modifier = Modifier.padding(5.dp)
                                        )
                                        TextField(
                                            value = step.value,
                                            onValueChange = {
                                                step.value = it
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
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .wrapContentSize(Alignment.TopStart)
                            )
                            {
                                Row()
                                {
                                    Text(
                                        "Input comparator",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                    IconButton(onClick = { expanded = !expanded }) {
                                        Icon(
                                            Icons.Outlined.Add,
                                            contentDescription = "",
                                            modifier = Modifier.size(20.dp),
                                            tint = Color.White
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false }
                                    ) {
                                        DropdownMenuItem(
                                            text = { Text("==") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "==",
                                                    Toast.LENGTH_SHORT
                                                ).show();block.inputComparator = "=="
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">=") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    ">=",
                                                    Toast.LENGTH_SHORT
                                                ).show();block.inputComparator = ">="
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<=") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "<=",
                                                    Toast.LENGTH_SHORT
                                                ).show();block.inputComparator = "<="
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    ">",
                                                    Toast.LENGTH_SHORT
                                                ).show();block.inputComparator = ">"
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "<",
                                                    Toast.LENGTH_SHORT
                                                ).show(); block.inputComparator = "<"
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("!=") },
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "!=",
                                                    Toast.LENGTH_SHORT
                                                ).show();block.inputComparator = "!="
                                            }

                                        )
                                    }
                                }

                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {
                            block.valueVar = varIterator.value
                            block.inputEditLeft = equal.value
                            block.inputEditMiddle = compare.value
                            block.inputEditRight = step.value
                            block.inputComparator = comparator.value
                            showExtendView.value = false
                            //block.runBlock()
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
        DrawForBlock(block)
    }
}

@Preview
@Composable
fun PreviewForBlock() {
    DrawForBlock(block = ForCycle())
}

@Preview
@Composable
fun PreviewExtededForBlock() {
    DrawExtendedForBlock(block = ForCycle())
}

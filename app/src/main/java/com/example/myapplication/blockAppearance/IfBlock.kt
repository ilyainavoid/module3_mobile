package com.example.myapplication.blockAppearance

import androidx.compose.runtime.setValue
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
import androidx.compose.runtime.getValue
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.wrapContentSize
import com.example.myapplication.logic.ConditionIf
import android.widget.Toast
import androidx.compose.material.icons.outlined.Add


@Composable
fun ifBlockAppearance(block:ConditionIf) {
    val showExtendView = remember { mutableStateOf(false) }

    val leftPart = remember { mutableStateOf(block.inputEditLeft) }
    val rightPart = remember { mutableStateOf(block.inputEditRight) }
    val comparator = remember { mutableStateOf(block.inputComparator)}
    if (leftPart.value == "" && rightPart.value =="") {
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
                    .background(Color.Black), contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            leftPart.value,
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
                            comparator.value,
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
                            rightPart.value,
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {
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
        }
     else {
        ExtendedIfBlockAppearance(block)
    }
}

@Composable
fun ExtendedIfBlockAppearance(block: ConditionIf) {

    val comparator = remember { mutableStateOf("")}
    val showExtendView = remember { mutableStateOf(true) }
    val leftPart = remember { mutableStateOf("") }
    val rightPart = remember { mutableStateOf("") }
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
                    .background(Color.Black), contentAlignment = Alignment.Center
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
                                            "Left part",
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
                                            block.inputComparator,
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
                                            "Right part",
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
                                        "Input left:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = leftPart.value,
                                        onValueChange = {
                                            leftPart.value = it
                                        },
                                        textStyle = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        modifier = Modifier
                                            .background(Color.Black)
                                            .padding(10.dp)
                                    )
                                }
                            }
                            Box() {
                                Row() {
                                    Text(
                                        "Input right:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = rightPart.value,
                                        onValueChange = {
                                            rightPart.value = it
                                        },
                                        textStyle = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        modifier = Modifier
                                            .background(Color.Black)
                                            .padding(10.dp)
                                    )
                                }
                            }
                            Box(modifier = Modifier
                                .fillMaxWidth(1f)
                                .wrapContentSize(Alignment.TopStart))
                            {
                                Row()
                                {
                                    Text(
                                        "Input comparator",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
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
                                            onClick = { Toast.makeText(context, "==", Toast.LENGTH_SHORT).show();block.inputComparator="==" }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">=") },
                                            onClick = { Toast.makeText(context, ">=", Toast.LENGTH_SHORT).show();block.inputComparator=">=" }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<=") },
                                            onClick = { Toast.makeText(context, "<=", Toast.LENGTH_SHORT).show();block.inputComparator="<=" }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">") },
                                            onClick = { Toast.makeText(context, ">", Toast.LENGTH_SHORT).show();block.inputComparator=">" }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<") },
                                            onClick = { Toast.makeText(context, "<", Toast.LENGTH_SHORT).show(); block.inputComparator="<"}
                                        )
                                        DropdownMenuItem(
                                            text = { Text("!=") },
                                            onClick = { Toast.makeText(context, "!=", Toast.LENGTH_SHORT).show();block.inputComparator="!=" }

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
                            block.inputEditLeft = leftPart.value
                            block.inputEditRight = rightPart.value
                            showExtendView.value = false
                            block.runBlock()
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
     else {
        ifBlockAppearance(block)
    }
}

@Preview
@Composable
fun PreviewIfBlock() {
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
                .background(Color.Black), contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        "Left part",
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
                        "==",
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
                        "Right part",
                        fontStyle = FontStyle(0),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f), contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
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
}

@Preview
@Composable
fun PreviewExtendedIfBlock() {

    val leftPart = remember { mutableStateOf("") }
    val rightPart = remember { mutableStateOf("") }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
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
                    .background(Color.Black), contentAlignment = Alignment.Center
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
                                            "Left part",
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
                                            "?",
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
                                            "Right part",
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
                                        "Input left:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = leftPart.value,
                                        onValueChange = {
                                            leftPart.value = it
                                        },
                                        textStyle = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        modifier = Modifier
                                            .background(Color.Black)
                                            .padding(10.dp)
                                    )
                                }
                            }
                            Box() {
                                Row() {
                                    Text(
                                        "Input right:",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    TextField(
                                        value = rightPart.value,
                                        onValueChange = {
                                            rightPart.value = it
                                        },
                                        textStyle = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        modifier = Modifier
                                            .background(Color.Black)
                                            .padding(10.dp)
                                    )
                                }
                            }
                            Box(modifier = Modifier
                                .fillMaxWidth(1f)
                                .wrapContentSize(Alignment.TopStart))
                            {
                                Row()
                                {
                                    Text(
                                        "Input comparator",
                                        fontStyle = FontStyle(0),
                                        color = Color.White,
                                        modifier = Modifier.padding(5.dp)
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
                                            onClick = { Toast.makeText(context, "==", Toast.LENGTH_SHORT).show() }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">=") },
                                            onClick = { Toast.makeText(context, ">=", Toast.LENGTH_SHORT).show() }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<=") },
                                            onClick = { Toast.makeText(context, "<=", Toast.LENGTH_SHORT).show() }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(">") },
                                            onClick = { Toast.makeText(context, ">", Toast.LENGTH_SHORT).show() }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("<") },
                                            onClick = { Toast.makeText(context, "<", Toast.LENGTH_SHORT).show() }
                                        )
                                        DropdownMenuItem(
                                            text = { Text("!=") },
                                            onClick = { Toast.makeText(context, "!=", Toast.LENGTH_SHORT).show() }
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
    }
}
























































































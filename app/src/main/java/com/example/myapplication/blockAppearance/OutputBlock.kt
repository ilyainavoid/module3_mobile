package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.logic.OutputBlock

@Composable
fun DrawOutputBlock(block: OutputBlock) {
    val message = remember { mutableStateOf(" ") }
    val variables = remember { mutableStateOf(" ") }
    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(.9f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
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
                Box(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
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
        }
    }
}

@Preview
@Composable
fun PreviewDrawOutputBlock(block: OutputBlock) {
    val message = remember { mutableStateOf(" ") }
    val variables = remember { mutableStateOf(" ") }
    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(.9f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
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
                Box(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
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
        }
    }
}
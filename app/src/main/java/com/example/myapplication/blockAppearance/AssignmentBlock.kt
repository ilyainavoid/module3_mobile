package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.myapplication.logic.Equation

@Composable
fun AssignmentBlockAppearance(block: Equation) {
    val showExtendView = remember { mutableStateOf(false) }

    val variableName = remember { mutableStateOf(block.inputEditLeft) }
    val variableValue = remember { mutableStateOf(block.inputEditRight) }

    if (variableName.value == "" && variableValue.value == "") {
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
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.3f), contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            block.inputEditLeft,
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
                            block.inputEditRight.toString(),
                            fontStyle = FontStyle(0),
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { showExtendView.value = true }) {
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
        ExtendedAssignmentBlockAppearance(block)
    }
}

fun ExtendedAssignmentBlockAppearance(block: Equation) {

}
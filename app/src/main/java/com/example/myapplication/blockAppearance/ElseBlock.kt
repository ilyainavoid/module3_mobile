package com.example.myapplication.blockAppearance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawElsetBlock() {
    Card(
        modifier = Modifier
            .fillMaxWidth(.8f)

            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.radialGradient(
                        listOf(Color(153, 29, 5), Color.White),
                        Offset.Unspecified, 600f
                    )
                ), contentAlignment = Alignment.Center
        ) {
            Text(
                "else",
                fontStyle = FontStyle(0),
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewElseBlock() {
    DrawElsetBlock()
}
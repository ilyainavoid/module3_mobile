package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.myapplication.ui.theme.MyApplicationTheme

class BlocksCatalog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Column() {
                        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxWidth(1f)) {
                            Text(text = "Block menu", fontSize = 8.em)
                        }
                        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 5.dp)) {
                            LazyColumn(
                            ) {
                                items(count = 5) {
                                    Button(
                                        onClick = {
                                            val intent = Intent(context, ProjectWorkspace::class.java)
                                            intent.putExtra("status", true)
                                            context.startActivity(intent)
                                            finish()
                                        },
                                        modifier = Modifier.fillMaxWidth(0.8f)
                                    ) {
                                        Text(text = "blockName")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}

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
import com.example.myapplication.logic.BlocksController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(contentAlignment = Alignment.Center) {
        Column() {
            Text(text = "CodeBlocks", modifier = Modifier.padding(horizontal = 55.dp))
            val context = LocalContext.current
            Button(onClick = {
                val intent = Intent(context, ProjectWorkspaceActivity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.fillMaxWidth(0.5f)) {
                Text(text = "Start")
            }
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    Box(contentAlignment = Alignment.Center) {
        Column() {
            Text(text = "CodeBlocks", modifier = Modifier.padding(horizontal = 55.dp))
            val context = LocalContext.current
            Button(onClick = {
                val intent = Intent(context, ProjectWorkspaceActivity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.fillMaxWidth(0.5f)) {
                Text(text = "Start")
            }
        }
    }
}


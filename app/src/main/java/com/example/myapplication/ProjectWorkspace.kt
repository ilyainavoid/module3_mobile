package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ProjectWorkspace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setDefaultContent()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setDefaultContent()
                    //createDefinedVar();
                }
            }
        }
    }
}

@Composable
fun setDefaultContent() {
    val context = LocalContext.current
    Box(contentAlignment = Alignment.BottomStart) {
        Button(onClick = {
            val intent = Intent(context, BlocksCatalog::class.java)
            context.startActivity(intent)
        }, modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(horizontal = 15.dp, vertical = 5.dp)) {
            Text(text = "Blocks")
        }
    }
    Box(contentAlignment = Alignment.BottomEnd) {
        Button(onClick = {
            val intent = Intent(context, Console::class.java)
            context.startActivity(intent)
        }, modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(horizontal = 15.dp, vertical = 5.dp)) {
            Text(text = "Console")
        }
    }
}
@Composable
fun createDefinedVar() {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box() {
            Row() {

            }
        }
    }
}
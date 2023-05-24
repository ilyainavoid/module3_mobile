package com.example.myapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.myapplication.logic.ConsoleAdapter

object Console : Tab {
    val adapterConsole = ConsoleAdapter()
    override val options: TabOptions
        @Composable
        get() {
            val MyAppIcons = Icons.Filled
            val icon = rememberVectorPainter(MyAppIcons.Terminal)
            return remember {
                TabOptions(
                    index = 2u,
                    title = "Console",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent()
    }
}
package com.example.myapplication.navigation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.BlocksController

object CodeEditor : Tab {
    val controller = BlocksController()
    val blocksList = controller.blockList
    override val options: TabOptions
        @Composable
        get() {
            val MyAppIcons = Icons.Filled
            val icon = rememberVectorPainter(MyAppIcons.Home)
            return remember {
                TabOptions(
                    index = 1u,
                    title = "CodeEditor",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent()
    }
}
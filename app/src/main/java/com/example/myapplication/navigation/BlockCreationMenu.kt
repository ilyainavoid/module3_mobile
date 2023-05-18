package com.example.myapplication.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.rounded.Terminal
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object BlockCreationMenu : Tab{
    override val options: TabOptions
    @Composable
        get() {
            val MyAppIcons = Icons.Filled
            val icon = rememberVectorPainter(MyAppIcons.Add)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "BlockCreationMenu",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent()
    }
}
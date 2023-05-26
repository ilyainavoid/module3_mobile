package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.BlocksController
import com.example.myapplication.logic.OK
import com.example.myapplication.navigation.BlockCreationMenu
import com.example.myapplication.navigation.CodeEditor
import com.example.myapplication.navigation.Console
import com.example.myapplication.ui.theme.MyApplicationTheme

class ProjectWorkspaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val controller = BlocksController()
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TabNavigator(CodeEditor) {
                        Scaffold(
                            content = { PaddingValues ->
                                CurrentTab()
                            },
                            bottomBar = {
                                BottomNavigation {
                                    TabNavigationItem(BlockCreationMenu)
                                    TabNavigationItem(CodeEditor)
                                    TabNavigationItem(Console)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title
            )
        }
    )
}
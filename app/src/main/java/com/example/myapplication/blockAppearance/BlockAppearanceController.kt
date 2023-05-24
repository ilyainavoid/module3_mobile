package com.example.myapplication.blockAppearance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.logic.Begin
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.StartProgram
import com.example.myapplication.logic.UndefiniedVariable

@Composable
fun BlockItem(displayedBlock: Any) {
    when(displayedBlock) {
        is Begin -> {

        }
        is DefiniedVar -> {
            DefinedVariableBlockAppearance(displayedBlock)
        }
        is UndefiniedVariable -> {
            UndefinedVariableBlockAppearance(displayedBlock)
        }
        is Equation -> {

        }
        is StartProgram -> {
            StartProgramBlockAppearance()
        }
    }
}
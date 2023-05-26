package com.example.myapplication.blockAppearance

import android.icu.util.Output
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.logic.Begin
import com.example.myapplication.logic.Block
import com.example.myapplication.logic.ConditionIf
import com.example.myapplication.logic.DefinedArray
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.End
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.Exit
import com.example.myapplication.logic.ForCycle
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.StartProgram
import com.example.myapplication.logic.UndefinedArray
import com.example.myapplication.logic.UndefiniedVariable

@Composable
fun BlockItem(displayedBlock: Any) {
    when (displayedBlock) {
        is Begin -> {
            DrawBeginProcessBlock(displayedBlock)
        }
        is End -> {
            DrawEndProcessBlock(displayedBlock)
        }
        is DefiniedVar -> {
            DrawDefinedVariableBlock(displayedBlock)
        }

        is UndefiniedVariable -> {
            DrawUndefinedVariableBlock(displayedBlock)
        }

        is Equation -> {
            DrawExtendedAssignmentBlock(displayedBlock)
        }

        is StartProgram -> {
            DrawStartProgramBlock(displayedBlock)
        }

        is OutputBlock -> {
            DrawOutputBlock(displayedBlock)
        }
        is Exit -> {
            DrawExitBlock()
        }
        is ConditionIf ->{
            DrawIfBlock(displayedBlock)
        }
        is UndefinedArray ->{
            DrawUndefinedArrayBlock(displayedBlock)
        }
        is DefinedArray ->{
            DrawDefinedArrayBlock(displayedBlock)
        }
        is ForCycle ->{
            DrawForBlock(displayedBlock)
        }
    }
}
package com.example.myapplication.blockAppearance

import androidx.compose.runtime.Composable
import com.example.myapplication.logic.Begin
import com.example.myapplication.logic.ConditionIf
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.End
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.Exit
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.StartProgram
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
        is ConditionIf -> {
            DrawExtendedIfBlock(displayedBlock)
        }
        is Exit -> {
            DrawExitBlock()
        }
    }
}
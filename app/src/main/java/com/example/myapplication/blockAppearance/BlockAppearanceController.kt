package com.example.myapplication.blockAppearance

import androidx.compose.runtime.Composable
import com.example.myapplication.logic.Begin
import com.example.myapplication.logic.ConditionIf
import com.example.myapplication.logic.DefinedArray
import com.example.myapplication.logic.DefiniedVar
import com.example.myapplication.logic.End
import com.example.myapplication.logic.Equation
import com.example.myapplication.logic.Exit
import com.example.myapplication.logic.OutputBlock
import com.example.myapplication.logic.StartProgram
import com.example.myapplication.logic.UndefinedArray
import com.example.myapplication.logic.UndefiniedVariable

@Composable
fun BlockItem(displayedBlock: Any) {
    when (displayedBlock) {
        is Begin -> {

        }

        is DefiniedVar -> {
            DefinedVariableBlockAppearance(displayedBlock)
        }

        is UndefiniedVariable -> {
            UndefinedVariableBlockAppearance(displayedBlock)
        }

        is Equation -> {
            DrawAssignmentBlock(displayedBlock)
        }

        is StartProgram -> {
            StartProgramBlockAppearance()
        }

        is OutputBlock -> {
            DrawOutputBlock(displayedBlock)
        }
        is Exit -> {
            DrawExitBlock()
        }
        is ConditionIf ->{
            ExtendedIfBlockAppearance(displayedBlock)
        }
        is UndefinedArray ->{
            UndefinedArrayBlockAppearance(displayedBlock)
        }
        is DefinedArray ->{
            DrawDefinedArrayBlock(displayedBlock)
        }
    }
}
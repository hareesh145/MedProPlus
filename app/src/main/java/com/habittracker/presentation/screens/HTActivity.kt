package com.habittracker.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.habittracker.presentation.navigation.HabitTrackerApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HTActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerApp()
        }
    }
}
package com.habittracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.habittracker.presentation.screens.AddEditHabitScreen
import com.habittracker.presentation.screens.HabitTrackerUI

import androidx.navigation.compose.rememberNavController
import com.habittracker.presentation.viewmodel.HabitViewModel

@Composable
fun HabitTrackerApp() {
    val navController = rememberNavController()
    val viewModel : HabitViewModel = viewModel()
    NavHost(navController = navController, startDestination = "habit_list") {
        composable("habit_list") {
            HabitTrackerUI(navController)
        }
        composable("add_edit_habit/{habitId}", arguments = listOf(navArgument("habitId") { defaultValue = -1 })) { backStackEntry ->
            val habitId = backStackEntry.arguments?.getInt("habitId") ?: -1
            AddEditHabitScreen(
                habit = viewModel.getHabitById(habitId), // Fetch habit or pass null for new habit
                onSaveClick = { habit ->
                    viewModel.addHabit(habit)
                },
                onCancelClick = { navController.popBackStack() }
            )
        }
    }
}

package com.habittracker.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habittracker.domain.model.Habit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditHabitScreen(
    habit: Habit?,
    onSaveClick: (Habit) -> Unit,
    onCancelClick: () -> Unit
) {
    var title by remember { mutableStateOf(habit?.name ?: "") }
    var description by remember { mutableStateOf(habit?.description ?: "") }
    var frequency by remember { mutableStateOf(habit?.frequency ?: Habit.Frequency.DAILY) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (habit == null) "Add Habit" else "Edit Habit") },
                navigationIcon = {
                    IconButton(onClick = onCancelClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Habit Title") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Frequency")
            Row {
                listOf(Habit.Frequency.DAILY, Habit.Frequency.WEEKLY, Habit.Frequency.MONTHLY).forEach {
                    Button(
                        onClick = { frequency = it },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(it.name)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                val newHabit = Habit(
                    id = habit?.id ?: 0,
                    name = title,
                    description = description,
                    frequency = frequency,
                    streak = habit?.streak ?: 0,
//                    completed = habit?.completed ?: 0
                )
                onSaveClick(newHabit)
            }) {
                Text("Save")
            }
        }
    }
}

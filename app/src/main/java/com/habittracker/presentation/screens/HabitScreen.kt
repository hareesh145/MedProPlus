package com.habittracker.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HabitTrackerUI(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Your Habits", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))

        HabitList(
            habits = listOf("Drink Water", "Exercise", "Read 10 Pages"),
            onCompleteHabit = {

            }
        )

        FloatingActionButton(
            onClick = {
                navController.popBackStack()
                navController.navigate("add_edit_habit/-1")
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Habit", tint = Color.White)
        }
    }
}

@Composable
fun HabitList(habits: List<String>, onCompleteHabit: (String) -> Unit) {
    Column {
        habits.forEach { habit ->
            HabitItem(habit, onCompleteHabit)
        }
    }
}

@Composable
fun HabitItem(habit: String, onCompleteHabit: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCompleteHabit(habit) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                habit,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { onCompleteHabit(habit) }) {
                Text("Complete")
            }
        }
    }
}


@Composable
fun LineChartView(dataPoints: List<Float>) {
//    AndroidView(factory = { context ->
//        LineChart(context).apply {
//            description = Description().apply { text = "Habit Progress" }
//            data = LineData(LineDataSet(dataPoints.mapIndexed { index, value ->
//                Entry(index.toFloat(), value)
//            }, "Progress"))
//        }
//    }, modifier = Modifier.fillMaxWidth().height(200.dp))
}

package com.habittracker.data.repository

import com.habittracker.data.local.HabitDao
import com.habittracker.domain.model.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class HabitRepository @Inject constructor(private val habitDao: HabitDao) {

    suspend fun addHabit(habit: Habit) {
        habitDao.insert(habit)
    }

    suspend fun updateHabit(habit: Habit) {
//        habitDao.update(habit.toEntity())  // ✅ Ensure completed status is saved
    }

    suspend fun markHabitAsCompleted(habit: Habit) {
//        val updatedHabit = habit.copy(completed = 1)  // ✅ Mark as completed
//        habitDao.updateCompletionStatus(habit.id, habit.completed==1)
    }

     fun getAllHabits(): Flow<List<Habit>> {
        return habitDao.getAllHabits().map { entities ->
            entities.map { it }  // Convert HabitEntity to Habit
        }
    }
}


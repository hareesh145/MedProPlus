package com.habittracker.domain.usecase

import com.habittracker.data.repository.HabitRepository
import com.habittracker.domain.model.Habit
import javax.inject.Inject

class MarkHabitAsCompletedUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend operator fun invoke(habit: Habit) {
        repository.markHabitAsCompleted(habit)
    }
}

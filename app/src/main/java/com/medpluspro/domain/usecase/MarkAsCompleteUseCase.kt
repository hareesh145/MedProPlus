package com.medpluspro.domain.usecase

import com.medpluspro.data.repository.HabitRepository
import com.medpluspro.domain.model.Habit
import javax.inject.Inject

class MarkHabitAsCompletedUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend operator fun invoke(habit: Habit) {
        repository.markHabitAsCompleted(habit)
    }
}

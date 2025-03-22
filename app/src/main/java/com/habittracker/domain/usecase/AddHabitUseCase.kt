package com.habittracker.domain.usecase

import com.habittracker.data.repository.HabitRepository
import com.habittracker.domain.model.Habit
import javax.inject.Inject

class AddHabitUseCase
@Inject constructor(
    private val habitRepository: HabitRepository) {
    suspend operator fun invoke(habit: Habit): Result<Unit> {
        return try {
            habitRepository.addHabit(habit)
            Result.success(Unit) // Return success
        } catch (e: Exception) {
            Result.failure(e) // Return failure
        }
    }
}


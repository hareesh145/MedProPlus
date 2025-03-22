package com.medpluspro.domain.usecase

import com.medpluspro.data.repository.HabitRepository
import com.medpluspro.domain.model.Habit
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


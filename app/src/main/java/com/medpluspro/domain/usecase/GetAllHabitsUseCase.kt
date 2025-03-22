package com.medpluspro.domain.usecase

import com.medpluspro.data.repository.HabitRepository
import com.medpluspro.domain.model.Habit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllHabitsUseCase @Inject constructor(private val repository: HabitRepository) {
    operator fun invoke(): Flow<List<Habit>> {
        return repository.getAllHabits()
    }
}


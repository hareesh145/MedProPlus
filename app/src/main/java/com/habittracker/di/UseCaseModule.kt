package com.habittracker.di

import com.habittracker.data.repository.HabitRepository
import com.habittracker.domain.usecase.AddHabitUseCase
import com.habittracker.domain.usecase.GetAllHabitsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetAllHabitsUseCase(repository: HabitRepository): GetAllHabitsUseCase {
        return GetAllHabitsUseCase(repository)
    }

    @Provides
    fun provideAddHabitUseCase(repository: HabitRepository): AddHabitUseCase {
        return AddHabitUseCase(repository)
    }
}
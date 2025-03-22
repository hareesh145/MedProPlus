package com.habittracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.habittracker.domain.model.Habit
import com.habittracker.domain.usecase.AddHabitUseCase
import com.habittracker.domain.usecase.GetAllHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(
    private val addHabitUseCase: AddHabitUseCase,
    getAllHabitsUseCase: GetAllHabitsUseCase
) : ViewModel() {

    val allHabits: LiveData<List<Habit>> = getAllHabitsUseCase().asLiveData()

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            val addInsert = addHabitUseCase(habit)
        }
    }

//    fun markHabitAsCompleted(habit: Habit) = viewModelScope.launch {
//        markHabitAsCompletedUseCase(habit)
//    }

    fun getHabitById(habitId: Int): Habit? {
        return allHabits.value?.find { it.id == habitId }
    }
}
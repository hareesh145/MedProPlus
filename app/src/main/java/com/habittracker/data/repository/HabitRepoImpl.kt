package com.habittracker.data.repository

import com.habittracker.data.local.HabitDao
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao
){

}

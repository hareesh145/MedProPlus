package com.medpluspro.data.repository

import com.medpluspro.data.local.HabitDao
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao
){

}

package com.medpluspro.utils

import com.medpluspro.data.local.HabitEntity
import com.medpluspro.domain.model.Habit


fun Habit.toEntity(): HabitEntity {
    return HabitEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        frequency = this.frequency.name,
        streak = this.streak,
        xpPoints = this.xpPoints,
//        completed = this.completed==1,  // ✅ Convert completed field
        createdAt = this.createdAt
    )
}

fun HabitEntity.toDomain(): Habit {
    return Habit(
        id = this.id,
        name = this.name,
        description = this.description,
        frequency = Habit.Frequency.valueOf(this.frequency),
        streak = this.streak,
        xpPoints = this.xpPoints,
//        completed = if(this.completed) 1 else 0,  // ✅ Convert completed field
        createdAt = this.createdAt
    )
}

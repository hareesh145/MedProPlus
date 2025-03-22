package com.medpluspro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val frequency: String = "DAILY",
    val streak: Int = 0,
    val xpPoints: Int = 0,
//    val completed: Boolean = false,  // ✅ Added completed field
    val createdAt: Long = System.currentTimeMillis()
)


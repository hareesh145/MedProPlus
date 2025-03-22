package com.medpluspro.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class Habit(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var streak: Int = 0,
    var xpPoints: Int = 0,
    var frequency: Frequency = Frequency.DAILY,
    var createdAt: Long = System.currentTimeMillis()
//    val completed: Int = 0
) {
    enum class Frequency {
        DAILY,
        WEEKLY,
        MONTHLY
    }
}
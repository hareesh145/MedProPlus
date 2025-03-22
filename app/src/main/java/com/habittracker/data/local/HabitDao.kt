package com.habittracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.habittracker.domain.model.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(habit: Habit)

    @Query("SELECT * FROM habit")
    fun getAllHabits(): Flow<List<Habit>>
//    @Update
//    suspend fun update(habit: HabitEntity): Int

   /* @Delete
    suspend fun delete(habit: HabitEntity): Int
*/
//    @Query("SELECT * FROM habits ORDER BY createdAt DESC")
//    fun getAllHabits(): Flow<List<HabitEntity>>
//
//    @Update
//    fun updateCompletionStatus(habitId: Int, isCompleted: Boolean): Int

}

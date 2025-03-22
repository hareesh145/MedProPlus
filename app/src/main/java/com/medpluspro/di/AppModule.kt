package com.medpluspro.di

import android.content.Context
import androidx.room.Room
import com.medpluspro.data.local.HabitDao
import com.medpluspro.data.local.HabitDatabase
import com.medpluspro.data.repository.HabitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HabitDatabase {
        return Room.databaseBuilder(
            context,
            HabitDatabase::class.java,
            "habit_database"
        ).build()
    }

    @Provides
    fun provideHabitDao(database: HabitDatabase): HabitDao {
        return database.habitDao()
    }

    @Provides
    fun provideHabitRepository(habitDao: HabitDao): HabitRepository {
        return HabitRepository(habitDao)
    }


}
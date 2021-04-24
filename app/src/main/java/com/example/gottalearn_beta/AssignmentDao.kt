package com.example.gottalearn_beta

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AssignmentDao {

        @Query("SELECT * FROM Assignment")
        fun getAll(): Flow<List<Assignment>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(assignment: Assignment)

        @Query("DELETE FROM Assignment")
        suspend fun deleteAll()
}


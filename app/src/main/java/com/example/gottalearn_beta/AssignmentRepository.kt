package com.example.gottalearn_beta


import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class AssignmentRepository (private val assignmentDao: AssignmentDao){

    val allAssignment: Flow<List<Assignment>> = assignmentDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(assignment: Assignment) {
        assignmentDao.insert(assignment)
    }


}
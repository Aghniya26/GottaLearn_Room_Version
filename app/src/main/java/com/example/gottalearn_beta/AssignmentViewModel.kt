package com.example.gottalearn_beta

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AssignmentViewModel (private val repository: AssignmentRepository):ViewModel()  {

    val allAssignment: LiveData<List<Assignment>> = repository.allAssignment.asLiveData()

    fun insert(assignment: Assignment) = viewModelScope.launch {
        repository.insert(assignment)
    }
}

class AssignmentViewModelFactory(private val repository: AssignmentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AssignmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AssignmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

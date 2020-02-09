package com.pi.connect.scripts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pi.connect.api.model.ErrorResponse
import com.pi.connect.api.model.Script
import com.pi.connect.repo.RepositoryImpl
import kotlinx.coroutines.launch
import com.pi.connect.api.model.Result.GenericError
import com.pi.connect.api.model.Result.NetworkError
import com.pi.connect.api.model.Result.Success

class ConnectViewModel : ViewModel() {

    private val _scripts = MediatorLiveData<List<Script>>()
    private val _error = MediatorLiveData<ErrorResponse>()


    private val scriptRepo = RepositoryImpl()
    val scripts: LiveData<List<Script>> get() = _scripts
    val error: LiveData<ErrorResponse> get() = _error

    init {
        retrieveScripts()
    }

    private fun retrieveScripts() {
        viewModelScope.launch {
            when (val scriptResponse = scriptRepo.retrieveScripts()) {
                is NetworkError -> _error.postValue(ErrorResponse(message = "Network Error"))
                is GenericError -> _error.postValue(scriptResponse.error)
                is Success -> _scripts.postValue(scriptResponse.value)
            }
        }
    }


}

package com.pi.connect.setup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pi.connect.api.model.Result
import com.pi.connect.repo.RepositoryImpl
import kotlinx.coroutines.launch

class SetUpViewModel : ViewModel() {
    val successfulLogin: MutableLiveData<Boolean> = MutableLiveData()
    private val scriptRepo = RepositoryImpl()


    fun connectToIpAddress(ipAddress: String) {
        viewModelScope.launch {
            when (scriptRepo.connectToPi(ipAddress)) {
                is Result.NetworkError -> successfulLogin.postValue(false)
                is Result.GenericError -> successfulLogin.postValue(false)
                is Result.Success -> successfulLogin.postValue(true)
            }
        }
    }
}
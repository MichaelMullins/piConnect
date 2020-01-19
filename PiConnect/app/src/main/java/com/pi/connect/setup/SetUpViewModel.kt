package com.pi.connect.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SetUpViewModel : ViewModel() {
    val successfulLogin: LiveData<Boolean> = MutableLiveData()

}
package com.pi.connect

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pi.connect.api.model.Script
import com.pi.connect.repo.Repo
import kotlinx.coroutines.Dispatchers

class ConnectViewModel : ViewModel() {
    private val scriptRepo = Repo()
    private val scripts: LiveData<List<Script>>

    init {
        scripts = liveData(Dispatchers.IO) {
            val retrievedScripts = scriptRepo.retrieveScripts()
            emit(retrievedScripts)
        }
    }

    fun retrieveScripts(): LiveData<List<Script>> {
        return scripts
    }


}

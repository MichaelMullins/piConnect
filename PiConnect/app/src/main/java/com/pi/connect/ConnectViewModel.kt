package com.pi.connect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pi.connect.api.model.Script
import com.pi.connect.repo.RepositoryImpl
import kotlinx.coroutines.launch
import com.pi.connect.api.model.Result.GenericError
import com.pi.connect.api.model.Result.NetworkError
import com.pi.connect.api.model.Result.Success

class ConnectViewModel : ViewModel() {

    private val _movies = NonNullMediatorLiveData<List<MovieResponse.Movie>>()
    private val _error = NonNullMediatorLiveData<String>


    private val scriptRepo = RepositoryImpl()
    private var scripts: List<Script>

//    init {
//        scripts = liveData(Dispatchers.IO) {
//            val retrievedScripts = scriptRepo.retrieveScripts()
//            emit(retrievedScripts)
//        }
//    }
    init {
    retrieveScripts()
}

    private fun retrieveScripts(){
        viewModelScope.launch{
            val scriptResponse = scriptRepo.retrieveScripts()
            when (scriptResponse) {
                is NetworkError -> scripts.
                is GenericError -> showGenericError(redditResponse)
                is Success -> scripts = scriptResponse.value
            }
        }
    }

//    fun retrieveScripts(): LiveData<List<Script>> {
//        return scripts
//    }


}

package com.pi.connect.repo

import com.pi.connect.api.model.Result
import com.pi.connect.api.buildPiService
import com.pi.connect.api.model.Script
import com.pi.connect.api.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface Repository {
    suspend fun retrieveScripts(): Result<List<Script>>
}

class RepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : Repository {
    private val piService by lazy { buildPiService() }

    override suspend fun retrieveScripts(): Result<List<Script>> {
        return safeApiCall(dispatcher) { piService.getScripts() }
    }
}
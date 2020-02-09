package com.pi.connect.repo

import com.pi.connect.api.PiService
import com.pi.connect.api.model.Result
import com.pi.connect.api.buildPiService
import com.pi.connect.api.model.Script
import com.pi.connect.api.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface Repository {
    suspend fun retrieveScripts(): Result<List<Script>>
    suspend fun connectToPi(ipAddress: String): Result<Unit>
}

class RepositoryImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : Repository {
    private lateinit var piService:PiService

    override suspend fun retrieveScripts(): Result<List<Script>> {
        return safeApiCall(dispatcher) { piService.getScripts() }
    }

    override suspend fun connectToPi(ipAddress: String): Result<Unit> {
        //Not sure this is the right thing to do here.
        piService = buildPiService(ipAddress)
        return safeApiCall(dispatcher) { piService.connectToPi() }
    }
}
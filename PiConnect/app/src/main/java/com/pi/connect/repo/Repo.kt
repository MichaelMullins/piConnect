package com.pi.connect.repo

import com.pi.connect.api.buildPiService
import com.pi.connect.api.model.Script

class Repo {
    private val piService by lazy { buildPiService() }

    suspend fun retrieveScripts(): List<Script> {
        return piService.getScripts()
    }
    fun executeScript(scriptId: Int){
        //tell (PiService) to run specified script
        piService.runScript(scriptId)
    }
}
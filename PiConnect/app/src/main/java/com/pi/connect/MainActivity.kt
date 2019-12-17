package com.pi.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val pythonScripts: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, createConnectFragment())
            .commit()


        addPythonScripts()
        rv_pythonScripts_list.layoutManager = LinearLayoutManager(this)
        rv_pythonScripts_list.adapter = PythonScriptAdapter(pythonScripts, this)
    }
    fun addPythonScripts() {
        pythonScripts.add("scriptName")
        pythonScripts.add("scriptName2")
        pythonScripts.add("otherScript")
        pythonScripts.add("fakeScript")
        pythonScripts.add("blah blah blah")
        pythonScripts.add("ScriptThingy")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")
        pythonScripts.add("duplicate")

    }
}

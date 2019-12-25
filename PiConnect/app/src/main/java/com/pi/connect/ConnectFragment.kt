package com.pi.connect

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.connect_fragment.*

fun createConnectFragment() = ConnectFragment()
class ConnectFragment : Fragment() {

    private lateinit var viewModel: ConnectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.connect_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConnectViewModel::class.java)
        rv_pythonScripts_list.layoutManager = LinearLayoutManager(activity)
        rv_pythonScripts_list.adapter = PythonScriptAdapter(viewModel.pythonScripts)
    }

}

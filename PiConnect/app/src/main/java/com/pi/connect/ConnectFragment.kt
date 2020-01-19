package com.pi.connect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pi.connect.api.model.Script
import kotlinx.android.synthetic.main.connect_fragment.*

const val CONNECT_FRAGMENT_TAG = "CONNECT_FRAGMENT"
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
        val adapter = PythonScriptAdapter()
        rv_pythonScripts_list.adapter = adapter
        viewModel.scripts.observe(viewLifecycleOwner, Observer {
            adapter.setScripts(it)
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            //tmp to fill in data remove when done testing.
            adapter.setScripts(
                listOf(
                    Script("script", 0),
                    Script("script numbah 2", 1)
                )
            )
            Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
        })
    }


}

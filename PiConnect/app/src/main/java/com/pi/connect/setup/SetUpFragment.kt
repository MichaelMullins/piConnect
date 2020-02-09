package com.pi.connect.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pi.connect.R
import com.pi.connect.scripts.CONNECT_FRAGMENT_TAG
import com.pi.connect.scripts.createConnectFragment
import kotlinx.android.synthetic.main.set_up_fragment.*

const val SET_UP_FRAGMENT_TAG = "Set Up Fragment"
fun createSetUpFragment() = SetUpFragment()
class SetUpFragment : Fragment() {
    private lateinit var viewModel: SetUpViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.connect_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SetUpViewModel::class.java)
        viewModel.successfulLogin.observe(viewLifecycleOwner, Observer {
            if (it) {
                edit_ip_address.error = null
                navigateToConnectFragment()
            } else {
                edit_ip_address.error = "IP Address did not connect successfully"
            }
        })
        button_ip_address.setOnClickListener {
            viewModel.connectToIpAddress(edit_ip_address.text.toString())
        }
    }

    private fun navigateToConnectFragment() {
        fragmentManager?.beginTransaction()
            ?.add(
                R.id.main_fragment_container,
                createConnectFragment(),
                CONNECT_FRAGMENT_TAG
            )
    }
}
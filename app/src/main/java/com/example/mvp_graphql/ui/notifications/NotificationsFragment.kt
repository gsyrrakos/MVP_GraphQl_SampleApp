package com.example.mvp_graphql.ui.notifications



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_graphql.LaunchListQuery
import com.example.mvp_graphql.R
import com.example.mvp_graphql.databinding.FragmentNotificationsBinding
import com.example.myapplication.ui.notifications.AdapterNotif
import com.example.myapplication.ui.notifications.Interactor
import com.example.myapplication.ui.notifications.Presenter


class NotificationsFragment : Fragment(), com.example.myapplication.ui.notifications.View {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val presenter = Presenter(this, Interactor())
     var adapter = AdapterNotif()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.launches.layoutManager = LinearLayoutManager(requireContext())
        binding.launches.adapter=adapter

        this.lifecycleScope.launchWhenStarted {
            presenter.getdtata()


        }


        return root
    }


    private fun validateCredentials() {
       // presenter.validateCredentials(username.text.toString(), password.text.toString())
    }


    override fun onDestroyView() {
        presenter.onDestroyView()
        super.onDestroyView()


    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility= View.GONE
    }

    override fun setAPIError() {

    }

    override fun setPasswordError() {

    }

    override fun getData(list: List<LaunchListQuery.Launch>) {

        adapter.setData(list)


    }
}
package com.example.mvp_graphql.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_graphql.Data.Restaurants

import com.example.mvp_graphql.databinding.FragmentHomeBinding


class HomeFragment : Fragment(),com.example.mvp_graphql.ui.home.ViewHome {


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val presenter = PresenterHome(this, InteractorHome())
    var adapter = Adapter()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=adapter

        this.lifecycleScope.launchWhenStarted {
            presenter.getdtata()


        }



        return root
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

    override fun getData(list: List<Restaurants>) {

        adapter.submitList(list)


    }
}
package com.light.submission2kelar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.light.submission2kelar.R
import com.light.submission2kelar.adapter.DetailUserAdapter
import com.light.submission2kelar.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_following.*

class FollowingFragment : Fragment() {

    private lateinit var followingViewModel : DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString(ARG_USERNAME)
        rv_user_following.layoutManager = LinearLayoutManager(requireActivity())
        rv_user_following.setHasFixedSize(true)

        if (username != null){
            showUser(username)
        }
    }

    private fun showProgressbar(state: Boolean) {
        if (state) {
            progressBarFollowing.visibility = View.VISIBLE
        } else {
            progressBarFollowing.visibility = View.INVISIBLE
        }
    }

    private fun showUser(username: String){
        showProgressbar(true)

        followingViewModel = ViewModelProvider(activity!!, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        followingViewModel.getDataUser(activity!!, username, "following")
        followingViewModel.getAllUsers().observe(this, {
            rv_user_following.adapter = DetailUserAdapter(it)
            showProgressbar(false)
        })
    }

    companion object {
        const val ARG_USERNAME = "username"

        fun newInstance(username: String?): FollowingFragment {
            val fragment = FollowingFragment()
            val bundle = Bundle()
            bundle.putString(ARG_USERNAME, username)
            fragment.arguments = bundle
            return fragment
        }
    }
}
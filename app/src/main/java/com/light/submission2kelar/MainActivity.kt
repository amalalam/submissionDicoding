package com.light.submission2kelar

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.light.submission2kelar.adapter.ListUserAdapter
import com.light.submission2kelar.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener(this)

        rv_user.layoutManager = LinearLayoutManager(this)
        rv_user.setHasFixedSize(true)

        showUser("c")
    }

    private fun showProgressBar(state: Boolean){
        if (state){
            progressBarMain.visibility = View.VISIBLE
        } else{
            progressBarMain.visibility = View.INVISIBLE
        }
    }

    private fun showUser(search: String){
        showProgressBar(true)

        userViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[UserViewModel::class.java]
        userViewModel.getDataUser(this, search)
        userViewModel.getAllUsers().observe(this, {
            rv_user.adapter = ListUserAdapter(it)
            showProgressBar(false)
        })
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_search){
            showUser( edit_username.text.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

}
package com.light.alam_githubappuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<User> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_food.setHasFixedSize(true)

        list.addAll(UserData.listData)
        showRecyclerList()
    }



    private fun showRecyclerList() {
        rv_food.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rv_food.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        Toast.makeText(this, "Kamu memilih " + user.name, Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "showSelecteduser:${user.name} " )
        val user = User(
            user.username,
            user.name,
            user.photo,
            user.company,
            user.location,
            user.repository,
            user.follower,
            user.following
        )

        val userWithObjectIntent = Intent(this, UserWithObjectActivity::class.java)
        userWithObjectIntent.putExtra(UserWithObjectActivity.EXTRA_USER, user)
        startActivity(userWithObjectIntent)
    }

}
package com.light.alam_githubappuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_with_object.*

class UserWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_with_object)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        description.text = user.username
        location.text = user.location
        repositori.text = user.repository.toString()
        company.text = user.company
        following.text = user.following.toString()
        follower.text = user.follower.toString()
        image.setImageResource(user.photo)


    }
}
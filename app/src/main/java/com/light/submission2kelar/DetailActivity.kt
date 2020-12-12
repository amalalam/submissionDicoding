package com.light.submission2kelar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.light.submission2kelar.adapter.SectionPagerAdapter
import com.light.submission2kelar.dataClass.UsersItems
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail User"

        val userItems = intent.getParcelableExtra<UsersItems>(EXTRA_DATA)


        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        sectionsPagerAdapter.username = userItems?.username
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f

        Glide.with(this)
                .load(userItems?.avatar)
                .apply(RequestOptions().override(70,70))
                .into(image)
        detail_name.text =  userItems?.name
        detail_username.text = getString(R.string.detail_username, userItems?.username )
        detail_repository.text = getString(R.string.repository, userItems?.company)
        detail_company.text= getString(R.string.company, userItems?.repository)
        detail_location.text=getString(R.string.location,userItems?.location)
    }
}
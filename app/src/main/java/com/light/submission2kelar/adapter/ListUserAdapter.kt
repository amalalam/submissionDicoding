package com.light.submission2kelar.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.light.submission2kelar.DetailActivity
import com.light.submission2kelar.R
import com.light.submission2kelar.dataClass.UsersItems
import kotlinx.android.synthetic.main.item_row_users.view.*

class ListUserAdapter(private val listUser: ArrayList<UsersItems>):
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: UsersItems){
            with(itemView){
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = user.name
                tv_item_username.text = itemView.context.getString(R.string.detail_username, user.username)
                tv_item_following.text = itemView.context.getString(R.string.number_following, user.following)
                tv_item_follower.text = itemView.context.getString(R.string.number_follower, user.follower)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_users, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val userData: UsersItems = listUser[position]
        holder.bind(listUser[position])
        holder.itemView.setOnClickListener {
            val usersIntent = UsersItems(
                userData.name,
                userData.username,
                userData.avatar,
                userData.follower,
                userData.company,
                userData.location,
                userData.following
            )
            val moveIntent = Intent(it.context, DetailActivity::class.java)
            moveIntent.putExtra(DetailActivity.EXTRA_DATA, usersIntent)
            it.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int =listUser.size
}
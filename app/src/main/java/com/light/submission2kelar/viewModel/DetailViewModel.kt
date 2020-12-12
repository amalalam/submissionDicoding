package com.light.submission2kelar.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.light.submission2kelar.dataClass.UsersItems
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class DetailViewModel : ViewModel() {

    val listUserMutable = MutableLiveData<ArrayList<UsersItems>>()
    private val listUsers = ArrayList<UsersItems>()
    private val client = AsyncHttpClient()

    init {
        client.addHeader("Authorization", "token c60065268e4d7b168f386d2665ae5518ae2bbcf7")
        client.addHeader("User-Agent", "request")
    }

    fun getAllUsers(): LiveData<ArrayList<UsersItems>> = listUserMutable

    fun getDataUser(context: Context, user: String, type: String) {
        listUsers.clear()

        val url = "https://api.github.com/users/$user/$type"
        client.get(
                url,
                object : AsyncHttpResponseHandler() {
                    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray) {
                        val result = String(responseBody)
                        Log.d("MainActivity", result)
                        try {
                            val jsonArray = JSONArray(result)
                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val username = jsonObject.getString("login")
                                val urlDetail = "https://api.github.com/users/$username"
                                client.get(urlDetail, object : AsyncHttpResponseHandler() {
                                    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray) {
                                        val results = String(responseBody)
                                        Log.d("MainActivity", results)
                                        try {
                                            val jsonObject = JSONObject(results)
                                            val usersItems = UsersItems()
                                            usersItems.avatar = jsonObject.getString("avatar_url")
                                            usersItems.username = jsonObject.getString("login")
                                            usersItems.name = jsonObject.getString("name")
                                            usersItems.repository = jsonObject.getString("public_repos")
                                            usersItems.company = jsonObject.getString("company")
                                            usersItems.location = jsonObject.getString("location")
                                            usersItems.follower = jsonObject.getString("followers")
                                            usersItems.following = jsonObject.getString("following")
                                            listUsers.add(usersItems)
                                            listUserMutable.postValue(listUsers)
                                        } catch (e: Exception) {
                                            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                                        }
                                    }

                                    override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                                        val errorMessage = when (statusCode) {
                                            401 -> "$statusCode : Bad Request"
                                            403 -> "$statusCode : Forbidden"
                                            404 -> "$statusCode : Not Found"
                                            else -> "$statusCode : ${error?.message}"
                                        }
                                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                    }
                                }
                                )

                            }

                        } catch (e: Exception) {
                            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                        val errorMessage = when (statusCode) {
                            401 -> "$statusCode : Bad Request"
                            403 -> "$statusCode : Forbidden"
                            404 -> "$statusCode : Not Found"
                            else -> "$statusCode : ${error?.message}"
                        }
                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                })
    }

}
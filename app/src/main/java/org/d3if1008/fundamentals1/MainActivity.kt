package org.d3if1008.fundamentals1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    private val userArrayList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setList()
        setData()
    }

    fun setList() {
        rv = findViewById(R.id.rv)
        rv.setLayoutManager(LinearLayoutManager(this))
        val listAdapter = ListAdapter(userArrayList)
        rv.setAdapter(listAdapter)
        rv.setHasFixedSize(true)
    }

    fun setData() {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataRepository = resources.getStringArray(R.array.repository)
        @SuppressLint("Recycle") val dataImage = resources.obtainTypedArray(R.array.avatar)

        for (i in dataName.indices) {
            val user = User()
            user.name = dataName[i]
            user.username = dataUsername[i]
            user.company = dataCompany[i]
            user.location = dataLocation[i]
            user.avatar = dataImage.getResourceId(i, -1)
            user.followers = dataFollowers[i]
            user.following = dataFollowing[i]
            user.repository = dataRepository[i]
            userArrayList.add(user)
        }
    }
}
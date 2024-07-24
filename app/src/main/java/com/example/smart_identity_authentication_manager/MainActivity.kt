package com.example.smart_identity_authentication_manager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smart_identity_authentication_manager.network.RetrofitInstance
import com.example.smart_identity_authentication_manager.network.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFetchUsers: Button = findViewById(R.id.btnFetchUsers)
        val tvUsers: TextView = findViewById(R.id.tvUsers)

        btnFetchUsers.setOnClickListener {
            RetrofitInstance.api.getUsers().enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        val users = response.body()
                        // Handle the list of users and display them in the TextView
                        val userNames = users?.joinToString("\n") { it.name }
                        tvUsers.text = userNames
                        Toast.makeText(this@MainActivity, "Retrieved ${users?.size} users", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, "Failed to retrieve users", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}

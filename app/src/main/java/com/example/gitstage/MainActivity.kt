package com.example.gitstage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gitstage.databinding.ActivityMainBinding
import com.example.gitstage.network.Callback2
import com.example.gitstage.network.GitHubService

//Adding binding, change in build.gradle

class MainActivity : AppCompatActivity() {

    val repoService = GitHubService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt1.setOnClickListener {
            repoService.fetchrepo(object: Callback2{
                override fun repositoryResult(result: ArrayList<RepositoryResponseItem>) {
                    Log.d("TEST","This is $result")
                }
            })

        }


    }



}
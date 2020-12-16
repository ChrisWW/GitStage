package com.example.gitstage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitstage.databinding.ActivityMainBinding
import com.example.gitstage.network.Callback2
import com.example.gitstage.network.GitHubService
import com.example.gitstage.repository.Repository
import com.example.gitstage.ui.RepositoryViewModel

//Adding binding, change in build.gradle

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : RepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
        viewModel.allRepo.observe(this, object: Observer<List<Repository>> {
            override fun onChanged(t: List<Repository>) {
                Log.d("TEST", "value of repository is $t")
            }
        })
            viewModel.getRepo()
        // observe(LifecycleOwner owner, Observer<? super T> observer)


    }



}
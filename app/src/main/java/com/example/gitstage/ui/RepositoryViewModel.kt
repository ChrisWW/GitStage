package com.example.gitstage.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitstage.network.GitHubService
import com.example.gitstage.repository.RepoRepository
import com.example.gitstage.repository.Repository
import com.example.gitstage.repository.RepositoryFetchCallback

class RepositoryViewModel : ViewModel() {

    private val repo: RepoRepository = RepoRepository(GitHubService())
    val allRepo: MutableLiveData<List<Repository>> = MutableLiveData()

    fun getRepo() {
        repo.fetchRepositories(object: RepositoryFetchCallback{
            override fun onRepositoriesFetched(repositories: List<Repository>) {
                allRepo.value = repositories
            }

        })
    }
}





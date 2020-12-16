package com.example.gitstage.repository

import com.example.gitstage.RepositoryResponseItem
import com.example.gitstage.network.Callback2
import com.example.gitstage.network.GitHubService

// kolejna funkcja, robi to samo co teraz w mainactivty- pobierane danych callback (OK)
// wykorzystaj for each / petla //// przeiteerowac kazdy  obiekt z teje listy i stworrrrrzyc obibekt repository
// mapowaanie z jsona juz p rzekonwawertowanego (OK)
// metoda np. fetchrepository, kolejny interface, callback, bedzie zwracal liste obiektow repository (OK)



class RepoRepository(private val githubService : GitHubService) {


        fun fetchRepositories(repositoriesFetchCallback : RepositoryFetchCallback){
            githubService.fetchrepo(object : Callback2 {
                override fun repositoryResult(result: ArrayList<RepositoryResponseItem>) {
                    repositoriesFetchCallback.onRepositoriesFetched(result.map{RepositoryResponseItem -> Repository(RepositoryResponseItem.id,RepositoryResponseItem.name,RepositoryResponseItem.stargazersUrl)})
                }
            })
        }
// https://api.github.com/repos/plotly/dash  brak stargazers_count

}

// zwraca liste z repository
interface RepositoryFetchCallback{
    fun onRepositoriesFetched(repositories : List<Repository>)
}
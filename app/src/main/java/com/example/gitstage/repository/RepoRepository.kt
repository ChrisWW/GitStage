package com.example.gitstage.repository

import com.example.gitstage.RepositoryResponseItem
import com.example.gitstage.network.Callback2
import com.example.gitstage.network.GitHubAPI
import com.example.gitstage.network.GitHubService

// kolejna funkcja, robi to samo co teraz w mainactivty- pobierane danych callback (OK)
// wykorzystaj for each / petla
// mapowaanie z jsona juz p rzekonwawertowanego
// metoda np. fetchrepository, kolejny interface, callback, bedzie zwracal liste obiektow repository (OK)
//// przeiteerowac kazdy  obiekt z teje listy i stworrrrrzyc obibekt repository


class RepoRepository(private val gitHubAPI: GitHubAPI) {

    // Return calej listy // Czy to powinienem zrobic jak object?

        val serviceGit = GitHubService()
        fun getRepos() {
            serviceGit.fetchrepo(object : Callback2 {
                override fun repositoryResult(result: ArrayList<RepositoryResponseItem>) {
                }
            }
            )

        }


// Bez sensu implementacja.. poprawic object itd.
 //   for (i in 0 until result.length ){
   //     mapOf(result.fullName to CallBackRepo.name, result.avatarUrl to CallBackRepo.photoUrl, result.stars to CallBackRepo.starsQuantity)
    // }


// map.forEach { key, value -> println("$key to $value")

  //  fun <K, V> Map<out K,V>.forEach() {}


   // fun mapRepo() {
      //  fun <K, V> Map<out K, V>.forEach{
        //    val value = object : CallBackRepo<K, V> -> Unit)
       // }


    //inline fun <K, V> Map<out K, V>.forEach(
      //      action: (Entry<K, V>) -> Unit)

    }


// zwraca liste z repository
interface CallBackRepo {

    fun get(repository: Repository)
}

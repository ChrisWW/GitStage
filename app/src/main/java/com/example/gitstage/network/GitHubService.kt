package com.example.gitstage.network


import android.util.Log
import com.example.gitstage.Owner
import com.example.gitstage.RepositoryResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET


// idk livedata, oddzielne repo dla bazy danych, LiveData<List<Repozytorium>>
// init repo...
// call gives us enqueue() puts on background thread - asynchronous messaging

// retrofit requesty na backend, kominukacja z serwerem(backend) Client -> retrofit > serwer(backend)
// Retrofit moze byc nullem

//Log.d("TEST","TEST")

class GitHubService {

    val repoAPI = RetrofitClientInstance.retrofitInstance?.create(GitHubAPI::class.java)

   fun fetchrepo(result: Callback2){

      repoAPI?.fetchRepo()?.enqueue(object : Callback<ArrayList<RepositoryResponseItem>> {

         override fun onResponse(call: Call<ArrayList<RepositoryResponseItem>>, response: Response<ArrayList<RepositoryResponseItem>>) {

             Log.d("TEST","response from back-end:${response.body()}")
             response.body()?.let { result.repositoryResult(it) }
         }

         override fun onFailure(call: Call<ArrayList<RepositoryResponseItem>>, t: Throwable) {

             Log.d("TEST","response from back-end:$t")

         }

      })
   }

    fun fetchrepo1(result1: Callback3){

       repoAPI?.fetchRepo()?.enqueue(object: Callback<ArrayList<RepositoryResponseItem>> {
           /**
            * Invoked for a received HTTP response.
            *
            *
            * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
            * Call [Response.isSuccessful] to determine if the response indicates success.
            */
           override fun onResponse(call: Call<ArrayList<RepositoryResponseItem>>, response: Response<ArrayList<RepositoryResponseItem>>) {
               TODO("Not yet implemented")
           }

           /**
            * Invoked when a network exception occurred talking to the server or when an unexpected exception
            * occurred creating the request or processing the response.
            */
           override fun onFailure(call: Call<ArrayList<RepositoryResponseItem>>, t: Throwable) {
               TODO("Not yet implemented")
           }


       })
    }



}

interface Callback2 {

    fun repositoryResult(
            result: ArrayList<RepositoryResponseItem>
    )

}

interface Callback3 {

    fun ownerResult(
            resultowner: ArrayList<Owner>
    )

}
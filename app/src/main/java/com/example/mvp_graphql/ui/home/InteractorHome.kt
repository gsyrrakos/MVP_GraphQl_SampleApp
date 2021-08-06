package com.example.mvp_graphql.ui.home

import android.util.Log
import com.example.mvp_graphql.Data.RepoRetrofit
import com.example.mvp_graphql.Data.Restaurants



class InteractorHome {


    private val repo: RepoRetrofit = RepoRetrofit()




    interface OnLoginFinishedListener {


        fun onError()

        fun onSuccess(list: List<Restaurants>)


    }








    suspend fun getData(listener: OnLoginFinishedListener) {

        var list: List<Restaurants>
        list = repo.getrest()
        if (list.isNullOrEmpty()) {
            listener.onError()

        } else {
            listener.onSuccess(list)
            Log.d("Susses",list.size.toString())

        }


    }


}
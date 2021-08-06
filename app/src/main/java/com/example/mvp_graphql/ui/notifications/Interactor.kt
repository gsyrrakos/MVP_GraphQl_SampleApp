package com.example.myapplication.ui.notifications

import android.util.Log
import com.example.mvp_graphql.LaunchListQuery
import com.example.myapplication.Data.RepoGraphql


class Interactor {


    private val repo: RepoGraphql = RepoGraphql()




    interface OnLoginFinishedListener {


        fun onError()

        fun onSuccess(list: List<LaunchListQuery.Launch>)


    }








    suspend fun getData(listener: OnLoginFinishedListener) {

        var list: List<LaunchListQuery.Launch>
        list = repo.queryCharactersList()
        if (list.isNullOrEmpty()) {
            listener.onError()

        } else {
            listener.onSuccess(list)
            Log.d("Susses",list.size.toString())

        }


    }


}
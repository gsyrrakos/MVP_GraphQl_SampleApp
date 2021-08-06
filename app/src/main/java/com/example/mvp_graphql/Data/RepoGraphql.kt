package com.example.myapplication.Data

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.coroutines.toFlow
import com.apollographql.apollo.exception.ApolloException
import com.example.mvp_graphql.LaunchListQuery
import com.example.mvp_graphql.api.apolloClient


class RepoGraphql  {

   val apollo= apolloClient()
   val launches = mutableListOf< LaunchListQuery.Launch> ()



     suspend fun queryCharactersList(): MutableList<LaunchListQuery.Launch> {
        var cursor: String? = null
        val response = try {
           apollo.query(LaunchListQuery(Input.fromNullable(cursor))).await()
        } catch (e: ApolloException) {
           Log.d("LaunchList", "Failure", e)
           null
        }
        if (response != null) {
           Log.d("Success", response.data?.launches?.launches.toString())
           val newLaunches = response?.data?.launches?.launches?.filterNotNull()

           if (newLaunches != null) {
              launches.addAll(newLaunches)

           }

        }
return launches
     }


}
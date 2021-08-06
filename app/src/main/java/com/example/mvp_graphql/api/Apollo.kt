package com.example.mvp_graphql.api

import android.content.Context
import android.os.Looper
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

private var instance: ApolloClient? = null

fun apolloClient(): ApolloClient {
    check(Looper.myLooper() == Looper.getMainLooper()) {
        "Only the main thread can get the apolloClient instance"
    }

    if (instance != null) {
        return instance!!
    }

    val okHttpClient = OkHttpClient.Builder()

        .build()

    instance = ApolloClient.builder()
        .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
        .subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory("wss://apollo-fullstack-tutorial.herokuapp.com/graphql", okHttpClient))
        .okHttpClient(okHttpClient)
        .build()

    return instance!!
}




package com.example.mvp_graphql.ui.home

import com.example.mvp_graphql.Data.Restaurants



interface ViewHome {
    fun showProgress()
    fun hideProgress()
    fun setAPIError()
    fun setPasswordError()
    fun getData(list: List<Restaurants>)
}
package com.example.myapplication.ui.notifications

import com.example.mvp_graphql.LaunchListQuery


interface View {
    fun showProgress()
    fun hideProgress()
    fun setAPIError()
    fun setPasswordError()
    fun getData(list: List<LaunchListQuery.Launch>)
}
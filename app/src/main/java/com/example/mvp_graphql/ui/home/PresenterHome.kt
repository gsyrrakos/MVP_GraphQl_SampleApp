package com.example.mvp_graphql.ui.home

import com.example.mvp_graphql.Data.Restaurants



class PresenterHome(var viewHome: ViewHome?, val interactorHome: InteractorHome) :
    InteractorHome.OnLoginFinishedListener {

     suspend fun getdtata(){

        viewHome?.showProgress()
        interactorHome.getData(this)


    }





    fun onDestroyView() {

        viewHome = null
    }

    override fun onError() {
        viewHome?.apply {
            setAPIError()
            hideProgress()
        }
    }



    override fun onSuccess(list: List<Restaurants>) {
        //loginView?.navigateToHome()
       viewHome?.apply {
         getData(list)
           hideProgress()
       }
    }
}
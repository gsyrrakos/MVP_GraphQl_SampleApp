package com.example.myapplication.ui.notifications

import com.example.mvp_graphql.LaunchListQuery


class Presenter(var view: View?, val interactor: Interactor) :
    Interactor.OnLoginFinishedListener {

     suspend fun getdtata(){

        view?.showProgress()
        interactor.getData(this)


    }



    fun validateCredentials(username: String, password: String) {
        view?.showProgress()
        //loginInteractor.login(username, password, this)

    }

    fun onDestroyView() {

        view = null
    }

    override fun onError() {
        view?.apply {
            setAPIError()
            hideProgress()
        }
    }



    override fun onSuccess(list: List<LaunchListQuery.Launch>) {
        //loginView?.navigateToHome()
       view?.apply {
         getData(list)
           hideProgress()
       }
    }
}
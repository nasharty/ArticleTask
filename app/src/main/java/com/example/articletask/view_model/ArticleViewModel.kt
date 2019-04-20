package com.example.articletask.view_model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.articletask.model.Result
import com.example.articletask.repo.ArticleRepo

class ArticleViewModel : ViewModel() {

    private val articleRepo = ArticleRepo()
    private var results: MutableLiveData<List<Result>>? = null

    init {
        articleRepo.callDataApi()
    }

    fun getResults(): MutableLiveData<List<Result>> {
        if (results == null) {
            results = MutableLiveData()
        }
        return articleRepo.results
    }
}

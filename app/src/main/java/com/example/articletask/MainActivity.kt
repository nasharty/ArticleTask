package com.example.articletask

import android.app.SearchManager
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.example.articletask.adapter.ArticleAdapter
import com.example.articletask.model.Result
import com.example.articletask.view_model.ArticleViewModel
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var searchView: SearchView
    private var results: MutableList<Result> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.toolbar_title)
        initView()
        checkObserver()
    }

    private fun initView() {
        articleAdapter = ArticleAdapter(this, results)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvArticle.layoutManager = layoutManager
        rvArticle.hasFixedSize()
        rvArticle.adapter = articleAdapter
    }

    private fun checkObserver(){
        val articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.getResults().observe(this,
            Observer<List<Result>> { results ->
                this.results.addAll(results!!)
                articleAdapter.notifyDataSetChanged()
            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Integer.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                articleAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                articleAdapter.filter.filter(query)
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }
}

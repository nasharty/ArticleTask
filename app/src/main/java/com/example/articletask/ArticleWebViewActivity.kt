package com.example.articletask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_article.*

class ArticleWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        if (intent.extras != null) {
            val articleUrl = intent.extras!!.getString(KEY_ARTICLE_URL)
            webview.loadUrl(articleUrl)
        }
    }

    companion object {
        const val KEY_ARTICLE_URL = "article_url"
    }
}

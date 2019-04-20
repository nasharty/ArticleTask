package com.example.articletask

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.test.filters.MediumTest

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.notNullValue
import org.junit.Assert.assertThat

@MediumTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun ensureListViewIsPresent() {
        val activity = rule.activity
        val viewById = activity.findViewById<View>(R.id.rvArticle)
        assertThat(viewById, notNullValue())
        assertThat(viewById, instanceOf(ListView::class.java))
        val recyclerView = viewById as RecyclerView
        val adapter = recyclerView.adapter
        assertThat<RecyclerView.Adapter<ViewHolder>>(adapter, instanceOf<RecyclerView.Adapter<ViewHolder>>(RecyclerView::class.java))
        assert(adapter != null)
        assertThat(adapter!!.itemCount, greaterThan(5))

    }
}
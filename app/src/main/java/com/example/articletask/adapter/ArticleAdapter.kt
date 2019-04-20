package com.example.articletask.adapter

import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.articletask.ArticleWebViewActivity
import com.example.articletask.R
import com.example.articletask.model.Result

class ArticleAdapter(private val context: Context, private val results: List<Result>) :
    RecyclerView.Adapter<ArticleAdapter.MyViewHolder>(), Filterable {

    private var resultListFiltered: List<Result>

    init {
        this.resultListFiltered = results
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        val holder = MyViewHolder(view)
        holder.containerLayout.setOnClickListener {
            val position = holder.containerLayout.tag as Int
            val articleUrl = resultListFiltered[position].url
            val intent = Intent(context, ArticleWebViewActivity::class.java)
            intent.putExtra(ArticleWebViewActivity.KEY_ARTICLE_URL, articleUrl)
            context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentResult = resultListFiltered[position]
        holder.containerLayout.tag = position
        Glide.with(context)
            .load(currentResult.media!![0].mediaMetadata!![1].url)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.articleImageView)
        holder.titleTextView.text = currentResult.title
        holder.byLineTextView.text = currentResult.byline
        holder.dateTextView.text = currentResult.publishedDate
    }

    override fun getItemCount(): Int {
        return resultListFiltered.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                resultListFiltered = if (charString.isEmpty()) {
                    results
                } else {
                    val filteredList = ArrayList<Result>()
                    for (row in results) {
                        if (row.title!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = resultListFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                notifyDataSetChanged()
            }
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val containerLayout: ConstraintLayout = itemView.findViewById(R.id.main_container)
        val articleImageView: ImageView = itemView.findViewById(R.id.article_iv)
        val titleTextView: TextView = itemView.findViewById(R.id.title_tv)
        val byLineTextView: TextView = itemView.findViewById(R.id.byline_tv)
        val dateTextView: TextView = itemView.findViewById(R.id.date_tv)

    }
}

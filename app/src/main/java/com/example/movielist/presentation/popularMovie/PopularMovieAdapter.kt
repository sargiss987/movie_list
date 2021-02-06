package com.example.movielist.presentation.popularMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.data.model.PopularMovie
import com.example.movielist.databinding.ListItemBinding

class PopularMovieAdapter(): RecyclerView.Adapter<PopularMovieAdapter.MyViewHolder>() {

    private val popularMovieList = ArrayList<PopularMovie>()

    fun setList(movies: List<PopularMovie>){
        popularMovieList.clear()
        popularMovieList.addAll(movies)
    }

    class MyViewHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(popularMovie: PopularMovie){
                binding.titleTextView.text = popularMovie.title
                binding.descriptionTextView.text = popularMovie.overview
                val posterUrl = "https://image.tmdb.org/t/p/w500"+popularMovie.posterPath
                Glide.with(binding.imageView.context)
                    .load(posterUrl)
                    .into(binding.imageView)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(popularMovieList[position])
    }

    override fun getItemCount(): Int {
        return popularMovieList.size
    }
}
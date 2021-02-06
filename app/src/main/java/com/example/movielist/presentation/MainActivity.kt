package com.example.movielist.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.R
import com.example.movielist.databinding.ActivityMainBinding
import com.example.movielist.presentation.di.Injector
import com.example.movielist.presentation.popularMovie.PopularMovieAdapter
import com.example.movielist.presentation.popularMovie.PopularMovieViewModel
import com.example.movielist.presentation.popularMovie.PopularMovieViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var popularMovieFactory: PopularMovieViewModelFactory
    private lateinit var popularMovieViewModel: PopularMovieViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PopularMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createPopularMovieSubComponent()
                .inject(this)

        popularMovieViewModel = ViewModelProvider(this,popularMovieFactory)
                .get(PopularMovieViewModel::class.java)


        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update -> {
                updatePopularMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updatePopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = popularMovieViewModel.updatePopularMovies()
        responseLiveData.observe(this, {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PopularMovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()

    }
    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = popularMovieViewModel.getPopularMovies()
        responseLiveData.observe(this, {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
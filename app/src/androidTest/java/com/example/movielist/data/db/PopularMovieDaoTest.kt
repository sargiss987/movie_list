package com.example.movielist.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movielist.data.model.PopularMovie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PopularMovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule =  InstantTaskExecutorRule()

    private lateinit var dao: PopularMovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java,

        ).build()

        dao = database.popularMovieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking{

             val movies = listOf<PopularMovie>(
                 PopularMovie(1,"overview1","posterPath1","title1"),
                 PopularMovie(2,"overview2","posterPath2","title2"),
                 PopularMovie(3,"overview3","posterPath3","title3"),
             )
        dao.savePopularMovies(movies)
        val allMovies = dao.getPopularMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMovieTest() = runBlocking {
        val movies = listOf<PopularMovie>(
            PopularMovie(1,"overview1","posterPath1","title1"),
            PopularMovie(2,"overview2","posterPath2","title2"),
            PopularMovie(3,"overview3","posterPath3","title3"),
        )

        dao.savePopularMovies(movies)
        dao.deleteAllPopularMovies()
        val moviesResult = dao.getPopularMovies()
        Truth.assertThat(moviesResult).isEmpty()


    }
}
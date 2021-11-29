package com.veronica.idn.firstsubmissionjetpack.view.movie.dashboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mansao.submissionandroidjetpackpro.data.MovieEntity
import com.veronica.idn.firstsubmissionjetpack.databinding.ItemWatchBinding
import com.veronica.idn.firstsubmissionjetpack.view.movie.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovie=  ArrayList<MovieEntity>()

    fun setMovie(movies : List<MovieEntity>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }


    inner class MovieViewHolder(var itemWatchBinding: ItemWatchBinding) :
        RecyclerView.ViewHolder(itemWatchBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val itemWatchBinding =
            ItemWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemWatchBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = listMovie.get(position)
        holder.itemWatchBinding.apply {
            tvTitleItem.text = movies.movieTitle
            tvGenderItem.text = movies.movieGenre
            tvRating.text = movies.movieRating
            tvDescriptionItem.text = movies.movieDescription
            Glide.with(holder.itemView.context).load(movies.moviePoster)
                .into(holder.itemWatchBinding.ivItem)
            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, movies.movieId)
                holder.itemView.context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int = listMovie.size
}


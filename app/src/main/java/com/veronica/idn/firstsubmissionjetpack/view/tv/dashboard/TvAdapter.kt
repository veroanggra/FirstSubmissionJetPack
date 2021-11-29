package com.veronica.idn.firstsubmissionjetpack.view.tv.dashboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mansao.submissionandroidjetpackpro.data.TvShowEntity
import com.veronica.idn.firstsubmissionjetpack.databinding.ItemWatchBinding
import com.veronica.idn.firstsubmissionjetpack.view.tv.detail.DetailTvActivity

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private val listTv = ArrayList<TvShowEntity>()


    fun setTv(tv: List<TvShowEntity>?) {
        if (tv == null) return
        this.listTv.clear()
        this.listTv.addAll(tv)
    }

    inner class TvViewHolder(var itemWatchBinding: ItemWatchBinding) :
        RecyclerView.ViewHolder(itemWatchBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemWatchBinding =
            ItemWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemWatchBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = listTv.get(position)
        holder.itemWatchBinding.apply {
            tvTitleItem.text = tv.tvTitle
            tvGenderItem.text = tv.tvGenre
            tvDescriptionItem.text = tv.tvDescription
            tvRating.text = tv.tvRating
            Glide.with(holder.itemView.context).load(tv.tvPoster)
                .into(holder.itemWatchBinding.ivItem)
            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_DATA, tv.tvId)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = listTv.size
}


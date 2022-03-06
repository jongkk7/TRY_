package com.yjk.atry._3_youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yjk.atry._3_youtube.presenter.YoutubePresenter
import com.yjk.atry._3_youtube.viewmodel.YoutubeViewModel
import com.yjk.atry.databinding.AdapterStage3SearchItemBinding
import com.yjk.common.callback.SingleCallback
import com.yjk.common.db.datamodel.YoutubeSearchDataModel
import com.yjk.common.util.TImageUtil

/**
 * 유튜브 검색어 리스트
 */
class AdapterYoutubeSearchWord(
    val context: Context,
    val viewModel: YoutubeViewModel,
    val list: ArrayList<YoutubeSearchDataModel>,
    val callback: SingleCallback<YoutubeSearchDataModel>
) :
    RecyclerView.Adapter<AdapterYoutubeSearchWord.YoutubeViewHolder>() {

    var presenter: YoutubePresenter = YoutubePresenter(context, viewModel)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val view = AdapterStage3SearchItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return YoutubeViewHolder(context, viewModel, presenter, callback, view)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addAll(list: ArrayList<YoutubeSearchDataModel>) {
        val position = this.list.size
        this.list.addAll(list)
        notifyItemRangeInserted(position, list.size)
    }

    class YoutubeViewHolder(
        private val context: Context,
        private val viewModel: YoutubeViewModel,
        private val presenter: YoutubePresenter,
        private val callback: SingleCallback<YoutubeSearchDataModel>,
        private val binding: AdapterStage3SearchItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: YoutubeSearchDataModel) {

            // search word
            binding.textViewTitle.text = item.searchWord

            // thumbnail
            if (!item.thumbnail.isEmpty()) {
                binding.imageViewThumbnail.setImageResource(0)
            } else {
                TImageUtil.loadImage(context, binding.imageViewThumbnail, item.thumbnail)
            }

            // item click
            binding.root.setOnClickListener {
                callback.onResult(item)
            }
        }
    }

}
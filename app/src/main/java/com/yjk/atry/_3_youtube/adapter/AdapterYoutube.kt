package com.yjk.atry._3_youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.yjk.atry.R
import com.yjk.atry._3_youtube.ActivityYoutube
import com.yjk.atry._3_youtube.presenter.YoutubePresenter
import com.yjk.atry._3_youtube.viewmodel.YoutubeViewModel
import com.yjk.atry.databinding.AdapterStage3YoutubeItemBinding
import com.yjk.common.callback.SingleCallback
import com.yjk.common.http.datamodel.youtube.YoutubeDataModel
import com.yjk.common.util.TImageUtil
import com.yjk.common.view.base.recyclerview.BaseRecyclerViewAdapter
import kotlin.coroutines.coroutineContext

class AdapterYoutube(
    val context: Context,
    val viewModel: YoutubeViewModel,
    val list: ArrayList<YoutubeDataModel>,
    val callback: SingleCallback<YoutubeDataModel>
) :
    RecyclerView.Adapter<AdapterYoutube.YoutubeViewHolder>() {

    var presenter: YoutubePresenter = YoutubePresenter(context, viewModel)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val view = AdapterStage3YoutubeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return YoutubeViewHolder(context, viewModel, presenter, view)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addAll(list : ArrayList<YoutubeDataModel>){
        val position = this.list.size
        this.list.addAll(list)
        notifyItemRangeInserted(position, list.size)
    }

    class YoutubeViewHolder(
        private val context: Context,
        private val viewModel: YoutubeViewModel,
        private val presenter: YoutubePresenter,
        private val binding: AdapterStage3YoutubeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: YoutubeDataModel) {

            // 동영상 썸네일
            TImageUtil.loadCircleImage(
                context,
                binding.imageViewThumbnail,
                item.snippet.thumbnails.medium.url
            )

            // title
            binding.textViewTitle.text = item.snippet.title


            // channel
            binding.imageViewThumbnail

            // channel info
            viewModel.channelLiveData.observe(context as ActivityYoutube, {

                val channelId = it.id
                val channelTitle = it.snippet.title
                val viewCount = it.statistics.viewCount + "회"
                val channelProfileUrl = it.snippet.thumbnails.medium.url

                if (item.snippet.channelId.equals(channelId)) {
                    // contents
                    binding.textViewContents.text = "$channelTitle · $viewCount"

                    // channel profile
                    TImageUtil.loadCircleImage(context, binding.imageViewChannel, channelProfileUrl)
                }

            })

            // get channel info
            if (!item.snippet.channelId.isEmpty()) {

                presenter.loadChannelInfo(item.snippet.channelId)

            } else {

                // contents
                binding.textViewContents.text = item.snippet.description

            }
        }
    }

}
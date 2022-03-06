package com.yjk.atry._3_youtube

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yjk.atry._3_youtube.adapter.AdapterYoutube
import com.yjk.atry._3_youtube.presenter.YoutubePresenter
import com.yjk.atry._3_youtube.viewmodel.YoutubeViewModel
import com.yjk.atry.databinding.ActivityStage103MainBinding
import com.yjk.common.view.base.BaseActivity

class ActivityYoutubeSearch : BaseActivity() {

    lateinit var binding: ActivityStage103MainBinding
    lateinit var presenter: YoutubePresenter
    lateinit var viewModel: YoutubeViewModel

    var adapter: AdapterYoutube? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setEvent()

        loadSearchWordList()
    }

    override fun initView() {
        binding = ActivityStage103MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init viewmodel
        viewModel = ViewModelProvider(this).get(YoutubeViewModel::class.java)

        // init presenter
        presenter = YoutubePresenter(mContext, viewModel)
    }

    override fun setEvent() {

    }

    fun loadSearchWordList(){

        presenter.getSearchWordList()

    }

}
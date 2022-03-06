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

class ActivityYoutube : BaseActivity() {

    lateinit var binding: ActivityStage103MainBinding
    lateinit var presenter: YoutubePresenter
    lateinit var viewModel: YoutubeViewModel

    var adapter: AdapterYoutube? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setEvent()

        loadList("")
    }

    override fun initView() {
        binding = ActivityStage103MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewContentsList.layoutManager = LinearLayoutManager(this)

        // init viewmodel
        viewModel = ViewModelProvider(this).get(YoutubeViewModel::class.java)
        viewModel.videoLiveData.observe(this, {
            if(adapter == null || adapter?.itemCount == 0) {
                adapter = AdapterYoutube(this, viewModel, it) {
                    // 영상 상세
                }
                binding.recyclerViewContentsList.adapter = adapter
            }else {
                adapter!!.addAll(it)
            }
        })

        // init presenter
        presenter = YoutubePresenter(mContext, viewModel)
    }

    override fun setEvent() {

        // 좋아요 영상 리스트
        binding.relativeLayoutLike.setOnClickListener {

        }

        // 영상 검색
        binding.relativeLayoutSearch.setOnClickListener {

        }

        // list page
        binding.recyclerViewContentsList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter?.itemCount
                if (lastVisibleItemPosition + 1 == itemTotalCount) {
                    loadList("")
                }
            }
        })
    }

    fun loadList(keyword: String) {
        presenter.loadList(keyword)
    }

}
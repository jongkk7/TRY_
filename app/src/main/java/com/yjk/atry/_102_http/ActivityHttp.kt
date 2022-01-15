package com.yjk.atry._102_http

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yjk.atry._101_room.datamodel.UserDataModel
import com.yjk.atry._101_room.repository.UserRepository
import com.yjk.atry._2_recyclerview_viewpager.step01.adapter.AdapterSimpleContents
import com.yjk.atry._2_recyclerview_viewpager.step01.datamodel.SimpleContentsDataModel
import com.yjk.atry.databinding.ActivityStage101MainBinding
import com.yjk.atry.databinding.ActivityStage102MainBinding
import com.yjk.common.view.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityHttp : BaseActivity() {

    lateinit var binding : ActivityStage102MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setEvent()

        loadList()
    }

    override fun initView() {

        binding = ActivityStage102MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewUserList.layoutManager = LinearLayoutManager(mContext)
    }

    override fun setEvent() {
        TODO("Not yet implemented")
    }

    fun loadList(){

    }

}
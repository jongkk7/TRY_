package com.yjk.atry._101_room

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yjk.atry._101_room.datamodel.UserDataModel
import com.yjk.atry._101_room.repository.UserRepository
import com.yjk.atry._2_recyclerview_viewpager.step01.adapter.AdapterSimpleContents
import com.yjk.atry._2_recyclerview_viewpager.step01.datamodel.SimpleContentsDataModel
import com.yjk.atry.databinding.ActivityStage101MainBinding
import com.yjk.common.view.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityRoom : BaseActivity() {

    var a: Int = 0

    lateinit var binding: ActivityStage101MainBinding
    var userRepository: UserRepository? = null
    var adapter: AdapterSimpleContents? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setEvent()

        loadList()

    }

    override fun initView() {
//        userRepository = UserRepository(mContext)

        binding = ActivityStage101MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewUserList.layoutManager = LinearLayoutManager(mContext)
    }

    override fun setEvent() {
//        TODO("Not yet implemented")

        binding.relativeLayoutAdd.setOnClickListener {
            addUser()
        }

    }

    fun addUser() {

        val id = System.currentTimeMillis().toInt()
        val name = "test$id"
        val user = UserDataModel(id, name, "-")

        CoroutineScope(Dispatchers.IO).launch {
            userRepository?.insertUser(user)
        }
        adapter?.addItem(SimpleContentsDataModel("${user.id}", user.name))

    }

    fun loadList() {

        CoroutineScope(Dispatchers.IO).launch {

            val userList = userRepository?.getUserList()
            val list = ArrayList<SimpleContentsDataModel>()

            if (userList != null) {
                for (user in userList) {
                    list.add(SimpleContentsDataModel("${user.id}", user.name))
                }
            }

            adapter = AdapterSimpleContents(mContext, list)

            runOnUiThread {
                binding.recyclerViewUserList.adapter = adapter
            }
        }


    }
}
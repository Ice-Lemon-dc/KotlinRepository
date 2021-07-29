package com.dc.kotlinrepository.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.adapter.HomeInfoAdapter
import com.dc.kotlinrepository.data_model.request.NetworkResultData
import com.dc.kotlinrepository.data_model.request.RequestAPI
import com.dc.kotlinrepository.entity.HomeDataResponse
import com.google.gson.Gson
import com.xiangxue.kotlinproject.config.Flag
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View? = inflater.inflate(R.layout.fragment_home, container, false)
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requestHomeData()
    }

    private fun requestHomeData() {
        RequestAPI.instanceRequest(Flag.SERVER_URL, object : NetworkResultData() {
            override fun requestFailure(info: String) {
                showResultError(info)
            }

            override fun requestSuccess(result: Response) {
                val resultData = result.body()?.string()
                val gson = Gson()
                val homeDataResponse = gson.fromJson(resultData, HomeDataResponse::class.java)
                showResultSuccess(homeDataResponse)
            }
        }, "1")
    }

    private fun showResultSuccess(homeDataResponse: HomeDataResponse) {
        text_home.text = "欢迎同学们的到来"
        home_rv.adapter = context?.let { HomeInfoAdapter(it, homeDataResponse.data.news_list) }
        context?.let { Glide.with(it).load(homeDataResponse.data.company_list[0].image).into(iv_top) }
        context?.let { Glide.with(it).load(homeDataResponse.data.ad_list[0].image).into(iv_bottom) }
    }

    private fun showResultError(errorMsg: String) {
        Toast.makeText(activity, "首页数据请求失败: errorMsg:$errorMsg", Toast.LENGTH_SHORT).show()
    }

}
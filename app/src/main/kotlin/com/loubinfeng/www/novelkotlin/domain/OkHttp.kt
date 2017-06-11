package com.loubinfeng.www.novelkotlin.domain

import okhttp3.OkHttpClient

/**
 * Created by loubinfeng on 2017/6/3.
 *
 * 获取okhttpclient的单例类
 */
class OkHttp private constructor(){

    private val client = OkHttpClient()

    private object Inner{
        val okhttp = OkHttp()
    }

    companion object{
        fun getInstance():OkHttp{
            return Inner.okhttp
        }
    }

    fun getOkHttpClient():OkHttpClient{
        return client
    }
}
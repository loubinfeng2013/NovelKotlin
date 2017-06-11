package com.loubinfeng.www.novelkotlin.model

/**
 * Created by loubinfeng on 2017/6/3.
 */
interface INovelModel {

    /**
     * 获取小说类别
     */
    fun getNovelClass()

    fun getNovelByClass(url : String)

    fun getNovelCataLog(url : String)

    fun getNovelDetail(url : String)
}
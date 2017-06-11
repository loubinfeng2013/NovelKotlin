package com.loubinfeng.www.novelkotlin.domain

/**
 * Created by loubinfeng on 2017/6/3.
 */

/**
 * 小说类型数据类
 * novelName:小说名字
 * novelUrl:该类型小说内容路径(作为唯一标示)
 */
data class NovelClass(var className: String, var classUrl: String)

data class Novel(var novelName: String, var novelUrl: String, var novelAuthor: String)

data class NovelCatalog(var catalogName: String, var catalogUrl: String, var novelUrl: String)

data class NovelDetail(var catalogName: String, var catalogUrl: String, var novelContent: String)

package com.loubinfeng.www.novelkotlin.view.viewinterface

import com.loubinfeng.www.novelkotlin.domain.NovelClass

/**
 * Created by loubinfeng on 2017/6/11.
 */
interface INovelClassView : IBaseView{
    fun onResultCall(result : List<NovelClass>)
}
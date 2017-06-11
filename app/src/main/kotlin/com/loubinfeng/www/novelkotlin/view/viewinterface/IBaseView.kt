package com.loubinfeng.www.novelkotlin.view.viewinterface

/**
 * Created by loubinfeng on 2017/6/11.
 */
interface IBaseView {
    /**
     * 开始刷新
     */
    fun onStartRefresh()

    /**
     * 结束刷新
     */
    fun onEndRefresh()
}
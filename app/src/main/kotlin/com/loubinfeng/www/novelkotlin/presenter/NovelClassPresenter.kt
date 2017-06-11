package com.loubinfeng.www.novelkotlin.presenter

import com.loubinfeng.www.novelkotlin.domain.NovelClass
import com.loubinfeng.www.novelkotlin.model.NovelModel
import com.loubinfeng.www.novelkotlin.view.viewinterface.INovelClassView

/**
 * Created by loubinfeng on 2017/6/11.
 */
class NovelClassPresenter(private val view: INovelClassView) {

    private var model: NovelModel? = null

    init {
        model = NovelModel { if (it is List<*>) {
            view.onResultCall(it.map { item -> item as NovelClass })
        } }
    }

    fun getNovelClassSource() {
        view.onStartRefresh()
        model?.getNovelClass()
    }

}
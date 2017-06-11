package com.loubinfeng.www.novelkotlin.model

import com.loubinfeng.www.novelkotlin.domain.Url
import com.loubinfeng.www.novelkotlin.domain.network.NovelCatalogSource
import com.loubinfeng.www.novelkotlin.domain.network.NovelClassSource
import com.loubinfeng.www.novelkotlin.domain.network.NovelDetailSource
import com.loubinfeng.www.novelkotlin.domain.network.NovelsByClassSource
import kotlin.concurrent.thread

/**
 * Created by loubinfeng on 2017/6/3.
 */
class NovelModel(val mCallBack: (Any) -> Unit) : INovelModel {

    override fun getNovelClass() {
        thread {
            mCallBack.invoke(NovelClassSource().obtain(Url.NOVEL_CLASS_URL))
        }
    }

    override fun getNovelByClass(url: String) {
        thread {
            mCallBack.invoke(NovelsByClassSource().obtain(url))
        }
    }

    override fun getNovelCataLog(url: String) {
        thread {
            mCallBack.invoke(NovelCatalogSource().obtain(url))
        }
    }

    override fun getNovelDetail(url: String) {
        thread {
            mCallBack.invoke(NovelDetailSource().obtain(url))
        }
    }
}
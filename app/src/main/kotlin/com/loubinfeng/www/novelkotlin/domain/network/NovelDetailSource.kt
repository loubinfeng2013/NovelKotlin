package com.loubinfeng.www.novelkotlin.domain.network

import com.loubinfeng.www.novelkotlin.domain.NovelDetail
import org.jsoup.Jsoup
import java.net.URL

/**
 * Created by loubinfeng on 2017/6/3.
 */
class NovelDetailSource : Source<NovelDetail>{
    override fun obtain(url: String): NovelDetail {
        var doc = Jsoup.parse(URL(url).openStream(),"GBK",url)
        return NovelDetail(doc.select("#nr_title")[0].text(),url,doc.select("#txt")[0].text())
    }
}
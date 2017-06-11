package com.loubinfeng.www.novelkotlin.domain.network

import com.loubinfeng.www.novelkotlin.domain.NovelClass
import org.jsoup.Jsoup
import java.net.URL

/**
 * Created by loubinfeng on 2017/6/3.
 */
class NovelClassSource : Source<List<NovelClass>> {
    override fun obtain(url: String): List<NovelClass>{
        var novelClassList = mutableListOf<NovelClass>()
        var doc = Jsoup.parse(URL(url).openStream(), "GBK", url)
        doc.select("a[href*=http://m.sangwu.org/class]").forEach {
            novelClassList.add(NovelClass(it.text(), it.attr("href")))
        }
        return novelClassList
    }

}
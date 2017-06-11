package com.loubinfeng.www.novelkotlin.domain.network

import com.loubinfeng.www.novelkotlin.domain.Novel
import org.jsoup.Jsoup
import java.net.URL

/**
 * Created by loubinfeng on 2017/6/3.
 */
class NovelsByClassSource : Source<List<Novel>> {
    override fun obtain(url: String): List<Novel>{
        var novelList = mutableListOf<Novel>()
        var doc = Jsoup.parse(URL(url).openStream(), "GBK", url)
        doc.select("p.line").forEach {
            val author = it.text().split("/")[1]
            val name = it.select("a")[0].text()
            val nurl = it.select("a")[0].attr("href")
            novelList.add(Novel(name, nurl, author))
        }
        return novelList
    }

}
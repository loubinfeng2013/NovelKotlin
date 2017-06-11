package com.loubinfeng.www.novelkotlin.domain.network

import com.loubinfeng.www.novelkotlin.domain.NovelCatalog
import org.jsoup.Jsoup
import java.net.URL

/**
 * Created by loubinfeng on 2017/6/3.
 */
class NovelCatalogSource : Source<List<NovelCatalog>>{
    override fun obtain(url: String): List<NovelCatalog> {
        var catalogList = mutableListOf<NovelCatalog>()
        var doc = Jsoup.parse(URL(url).openStream(),"GBK",url)
        doc.select("li").select("a").forEach {
            catalogList.add(NovelCatalog(it.text(),it.attr("href"),url))
        }
        return catalogList
    }
}
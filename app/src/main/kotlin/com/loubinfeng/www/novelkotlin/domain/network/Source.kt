package com.loubinfeng.www.novelkotlin.domain.network

/**
 * Created by loubinfeng on 2017/6/3.
 */
interface Source<T> {
    fun obtain(url:String):T
}
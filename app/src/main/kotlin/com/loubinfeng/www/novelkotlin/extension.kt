package com.loubinfeng.www.novelkotlin

import android.app.Fragment
import android.widget.Toast

/**
 * Created by loubinfeng on 2017/6/3.
 *
 * 扩展方法和通用方法
 */
fun Fragment.toast(string: String) {
    Toast.makeText(context, string, 2000)
}
package com.loubinfeng.www.novelkotlin.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loubinfeng.www.novelkotlin.R

/**
 * Created by loubinfeng on 2017/6/4.
 */
class CompleteNovelFragment : Fragment(){

    private var contentView : View ?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        contentView = inflater?.inflate(R.layout.completenovel_layout,null)
        return contentView?:View(context)
    }

}
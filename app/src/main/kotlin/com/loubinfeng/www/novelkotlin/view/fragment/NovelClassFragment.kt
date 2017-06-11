package com.loubinfeng.www.novelkotlin.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loubinfeng.www.novelkotlin.R
import com.loubinfeng.www.novelkotlin.domain.NovelClass
import com.loubinfeng.www.novelkotlin.presenter.NovelClassPresenter
import com.loubinfeng.www.novelkotlin.view.adapter.NovelClassAdapter
import com.loubinfeng.www.novelkotlin.view.viewinterface.INovelClassView

/**
 * Created by loubinfeng on 2017/6/4.
 */
class NovelClassFragment : Fragment(),INovelClassView {

    private var contentView : View ?= null
    private val refreshLayout : SwipeRefreshLayout by lazy { contentView?.findViewById(R.id.refresh_layout) as SwipeRefreshLayout }
    private val recyclerView : RecyclerView by lazy { contentView?.findViewById(R.id.recycler_view) as RecyclerView }
    private val presenter : NovelClassPresenter by lazy { NovelClassPresenter(this) }
    private val data : MutableList<NovelClass> by lazy { mutableListOf<NovelClass>() }
    private val adapter : NovelClassAdapter by lazy { NovelClassAdapter(data,context,null) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        contentView = inflater?.inflate(R.layout.novelclass_layout,null)
        return contentView ?:View(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        setListener()
        presenter.getNovelClassSource()
    }

    fun initView(){
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

    fun setListener(){
        refreshLayout.setOnRefreshListener {
            presenter.getNovelClassSource()
        }
        adapter.setOnItemClickListener {

        }
    }

    /*********************** INovelClassView *************************/

    override fun onStartRefresh() {
        activity.runOnUiThread {
            refreshLayout.isRefreshing = true
        }
    }

    override fun onResultCall(result: List<NovelClass>) {
        onEndRefresh()
        if (result.size > 0 ){
            activity.runOnUiThread {
                data.clear()
                data.addAll(result)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onEndRefresh() {
        activity.runOnUiThread {
            refreshLayout.isRefreshing = false
        }
    }
}
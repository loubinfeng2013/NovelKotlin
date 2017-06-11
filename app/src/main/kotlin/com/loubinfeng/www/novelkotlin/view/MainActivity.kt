package com.loubinfeng.www.novelkotlin.view

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.loubinfeng.www.novelkotlin.R
import com.loubinfeng.www.novelkotlin.view.fragment.BookshelfFragment
import com.loubinfeng.www.novelkotlin.view.fragment.CompleteNovelFragment
import com.loubinfeng.www.novelkotlin.view.fragment.NovelClassFragment
import com.loubinfeng.www.novelkotlin.view.fragment.RankListFragment

class MainActivity : AppCompatActivity() {

    private val naviView: NavigationView by lazy { findViewById(R.id.navi_layout) as NavigationView }
    private val drawerView: DrawerLayout   by lazy { findViewById(R.id.main_layout) as DrawerLayout }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setViewListener()
        switchFragment(NovelClassFragment())
    }

    private fun setViewListener() {
        naviView?.setNavigationItemSelectedListener {
            it.setCheckable(true)
            it.setChecked(true)
            drawerView?.closeDrawers()
            handleMenuClick(it)
            true
        }
    }

    private fun handleMenuClick(menuItem: MenuItem?) {
        menuItem?.let {
            when (menuItem.itemId) {
                R.id.menu_i1 -> switchFragment(NovelClassFragment())
                R.id.menu_i2 -> switchFragment(RankListFragment())
                R.id.menu_i3 -> switchFragment(CompleteNovelFragment())
                R.id.menu_i4 -> switchFragment(BookshelfFragment())
                else -> {
                }
            }
        }
    }

    fun switchFragment(targetFragment: Fragment?) {
        targetFragment?.let {
            fragmentManager?.beginTransaction()?.replace(R.id.main_content, targetFragment)?.commit()
        }
    }
}

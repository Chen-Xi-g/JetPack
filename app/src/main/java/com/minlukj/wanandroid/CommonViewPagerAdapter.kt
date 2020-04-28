package com.minlukj.wanandroid

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid
 * @ClassName:      CommonViewPagerAdapter
 * @Description:     kotlin类作用描述
 * @Author:         忞鹿
 * @CreateDate:     2020/4/27 11:18
 */
class CommonViewPagerAdapter(private val count : Int,private val enableDestroyItem : Boolean ,private val title: Array<String?>) : PagerAdapter() {

    override fun getCount(): Int {
        return count
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return container.getChildAt(position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (enableDestroyItem) {
            container.removeView(`object` as View)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}
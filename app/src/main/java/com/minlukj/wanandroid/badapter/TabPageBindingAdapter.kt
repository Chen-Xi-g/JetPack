package com.minlukj.wanandroid.badapter

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.minlukj.wanandroid.CommonViewPagerAdapter
import com.minlukj.wanandroid.R

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.badapter
 * @ClassName:      TabPageBindingAdapter
 * @Description:    TabLayout的BindingAdapter
 * @Author:         忞鹿
 * @CreateDate:     2020/4/27 11:17
 */
object TabPageBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["initTabAndPage"], requireAll = false)
    fun initTabAndPage(tabLayout: TabLayout, initTabAndPage: Boolean) {
        if (initTabAndPage) {
            val count = tabLayout.tabCount
            val title = arrayOfNulls<String>(count)
            for (i in 0 until count) {
                val tab = tabLayout.getTabAt(i)
                if (tab != null && tab.text != null) {
                    title[i] = tab.text.toString()
                }
            }
            val viewPager: ViewPager = tabLayout.rootView.findViewById(R.id.view_pager)
            viewPager.adapter = CommonViewPagerAdapter(count, false, title)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}
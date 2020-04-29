package com.minlukj.databinding.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.minlukj.databinding.CommonViewPagerAdapter
import com.minlukj.databinding.R

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.databinding.bindingadapter
 * @ClassName:      TabBindingAdapter
 * @Description:    TabLayoutBindingAdapter
 * @Author:         忞鹿
 * @CreateDate:     2020/4/29 14:04
 */
object TabBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["initTabAndTab"], requireAll = false)
    fun initTabAndPage(tabLayout : TabLayout, initTabAndPage : Boolean){
        if (initTabAndPage) {
            val count = tabLayout.tabCount
            val title = arrayOfNulls<String>(count)
            for (i in 0 until count) {
                val tab = tabLayout.getTabAt(i)
                if (tab != null && tab.text != null) {
                    title[i] = tab.text.toString()
                }
            }
            val viewPager: ViewPager = tabLayout.rootView.findViewById(R.id.vp)
            viewPager.adapter = CommonViewPagerAdapter(count, false, title)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}
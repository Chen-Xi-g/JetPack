package com.minlukj.lifecycles.ui

import com.minlukj.lifecycles.R
import com.minlukj.lifecycles.base.BaseActivity

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles.ui
 * @ClassName:      FragmentActivity
 * @Description:    FragmentActivity
 * @Author:         忞鹿
 * @CreateDate:     2020/5/29 11:12
 */
class FragmentActivity : BaseActivity() {
    override fun initView() {
        setContentView(R.layout.activity_fragment)
    }
}
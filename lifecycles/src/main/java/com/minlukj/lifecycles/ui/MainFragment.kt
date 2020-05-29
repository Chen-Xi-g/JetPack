package com.minlukj.lifecycles.ui

import com.minlukj.lifecycles.R
import com.minlukj.lifecycles.base.BaseFragment

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles
 * @ClassName:      MainFragment
 * @Description:    MainFragment
 * @Author:         忞鹿
 * @CreateDate:     2020/5/29 11:11
 */
class MainFragment : BaseFragment() {
    override fun initView() {
    }

    override fun layoutId(): Int {
        return R.layout.fragment_main
    }
}
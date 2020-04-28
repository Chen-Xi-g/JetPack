package com.minlukj.wanandroid.ui

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.ui
 * @ClassName:      BaseFragment
 * @Description:    Fragment基类
 * @Author:         忞鹿
 * @CreateDate:     2020/4/28 15:47
 */
open class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (isBackFragment()) {
            val callback: OnBackPressedCallback =
                object : OnBackPressedCallback(true /* enabled by default */) {
                    override fun handleOnBackPressed() { // Handle the back button event
                        if (!NavHostFragment.findNavController(this@BaseFragment).popBackStack())
                            activity?.finish()
                    }
                }
            requireActivity().onBackPressedDispatcher.addCallback(this, callback)
//        }
    }
    open fun isBackFragment() : Boolean{
        return false
    }
    fun nav() : NavController {
        return NavHostFragment.findNavController(this)
    }
}
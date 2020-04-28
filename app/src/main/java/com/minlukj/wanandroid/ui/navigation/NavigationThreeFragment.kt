package com.minlukj.wanandroid.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.minlukj.wanandroid.R
import com.minlukj.wanandroid.brideg.state.NavigationViewModel
import com.minlukj.wanandroid.databinding.FragmentNavigationThreeBinding
import com.minlukj.wanandroid.ui.BaseFragment

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.ui.navigation
 * @ClassName:      NavigationThreeFragment
 * @Description:    Navigation练习
 * @Author:         忞鹿
 * @CreateDate:     2020/4/28 14:30
 */
class NavigationThreeFragment : BaseFragment() {
    private lateinit var mBinding : FragmentNavigationThreeBinding
    private lateinit var vm : NavigationViewModel
    override fun isBackFragment(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this,defaultViewModelProviderFactory).get(NavigationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_navigation_three,container,false)
        mBinding = FragmentNavigationThreeBinding.bind(view)
        mBinding.vm = vm
        mBinding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.buttonName.set(getString(R.string.start_fragment_4))
    }


    inner class ClickProxy{
        fun startOneFragment(){
            nav().navigate(R.id.action_three_fragment_to_five_fragment)
        }
    }
}
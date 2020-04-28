package com.minlukj.wanandroid.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.minlukj.wanandroid.R
import com.minlukj.wanandroid.brideg.state.NavigationViewModel
import com.minlukj.wanandroid.databinding.FragmentNavigationBinding
import com.minlukj.wanandroid.ui.BaseFragment

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.ui.navigation
 * @ClassName:      NavigationFragment
 * @Description:    Navigation练习
 * @Author:         忞鹿
 * @CreateDate:     2020/4/28 14:19
 */
class NavigationFragment : BaseFragment() {
    private lateinit var mBinding : FragmentNavigationBinding
    private lateinit var vm : NavigationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this,defaultViewModelProviderFactory).get(NavigationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_navigation,container,false)
        mBinding = FragmentNavigationBinding.bind(view)
        mBinding.vm = vm
        mBinding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.buttonName.set(getString(R.string.start_fragment_2))
    }


    inner class ClickProxy{
        fun startOneFragment(){
            nav().navigate(R.id.action_one_fragment_to_two_fragment)
        }
    }
}
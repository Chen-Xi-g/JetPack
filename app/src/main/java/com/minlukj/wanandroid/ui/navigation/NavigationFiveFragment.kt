package com.minlukj.wanandroid.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.minlukj.wanandroid.R
import com.minlukj.wanandroid.brideg.state.NavigationViewModel
import com.minlukj.wanandroid.databinding.FragmentNavationFiveBinding
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
class NavigationFiveFragment : BaseFragment() {
    private lateinit var mBinding : FragmentNavationFiveBinding
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
        val view = layoutInflater.inflate(R.layout.fragment_navation_five,container,false)
        mBinding = FragmentNavationFiveBinding.bind(view)
        mBinding.vm = vm
        mBinding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.buttonName.set(getString(R.string.start_fragment_1))
    }

    inner class ClickProxy{
        fun startOneFragment(){
            nav().navigate(R.id.action_five_fragment_to_one_fragment)
        }
    }
}
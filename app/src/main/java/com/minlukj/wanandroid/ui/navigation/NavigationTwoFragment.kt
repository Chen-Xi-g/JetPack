package com.minlukj.wanandroid.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.minlukj.wanandroid.R
import com.minlukj.wanandroid.brideg.state.NavigationViewModel
import com.minlukj.wanandroid.databinding.FragmentNavigationTwoBinding
import com.minlukj.wanandroid.ui.BaseFragment


/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.ui.navigation
 * @ClassName:      NavigationTwoFragment
 * @Description:    Navigation练习
 * @Author:         忞鹿
 * @CreateDate:     2020/4/28 14:28
 */
class NavigationTwoFragment : BaseFragment() {
    private lateinit var mBinding : FragmentNavigationTwoBinding
    private lateinit var vm : NavigationViewModel
    override fun isBackFragment(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this,defaultViewModelProviderFactory).get(NavigationViewModel::class.java)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() { // Handle the back button event
                    NavHostFragment.findNavController(this@NavigationTwoFragment)
                        .popBackStack()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_navigation_two,container,false)
        mBinding = FragmentNavigationTwoBinding.bind(view)
        mBinding.vm = vm
        mBinding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.buttonName.set(getString(R.string.start_fragment_3))
    }

    inner class ClickProxy{
        fun startOneFragment(){
            nav().navigate(R.id.action_two_fragment_to_three_fragment)
        }
    }
}
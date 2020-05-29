package com.minlukj.lifecycles.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minlukj.lifecycles.observer.NetworkManager

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles.base
 * @ClassName:      BaseFragment
 * @Description:     kotlin类作用描述
 * @Author:         忞鹿
 * @CreateDate:     2020/4/29 16:13
 */
abstract class BaseFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(),container,false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(NetworkManager.instance)
        initView()
    }
    abstract fun initView()
    abstract fun layoutId() : Int
}
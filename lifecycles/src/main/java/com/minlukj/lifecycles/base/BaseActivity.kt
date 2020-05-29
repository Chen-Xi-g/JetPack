package com.minlukj.lifecycles.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minlukj.lifecycles.observer.NetworkManager

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles.base
 * @ClassName:      BaseActivity
 * @Description:     kotlin类作用描述
 * @Author:         忞鹿
 * @CreateDate:     2020/4/29 16:13
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(NetworkManager.instance)
        initView()
    }
    abstract fun initView()
}
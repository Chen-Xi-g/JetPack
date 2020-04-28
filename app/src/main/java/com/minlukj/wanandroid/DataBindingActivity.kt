package com.minlukj.wanandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minlukj.wanandroid.brideg.state.DataBindingViewModel
import com.minlukj.wanandroid.databinding.ActivityDatabindingBinding
import com.minlukj.wanandroid.ui.activity.NavigationActivity

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid
 * @ClassName:      DatabindingActivity
 * @Description:     kotlin类作用描述
 * @Author:         忞鹿
 * @CreateDate:     2020/4/27 10:33
 */
class DataBindingActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityDatabindingBinding
    private lateinit var mViewModel : DataBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(DataBindingViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_databinding)
        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel
        mBinding.click = ClickProxy()
        //设置是否初始化TabLayout
        mViewModel.initTabAndPage.set(true)
        //设置ViewModel中WebView load 地址
        mViewModel.pageAssetPath.set("https://www.minlukj.com/?p=121")
    }

    inner class ClickProxy{
        fun startNavigation(){
            startActivity(Intent(this@DataBindingActivity,NavigationActivity::class.java))
        }
    }

}
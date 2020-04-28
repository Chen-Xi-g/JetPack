package com.minlukj.wanandroid.brideg.state

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.brideg.state
 * @ClassName:      DataBindingViewModel
 * @Description:    DataBinding ViewModel
 * @Author:         忞鹿
 * @CreateDate:     2020/4/27 10:44
 */
class DataBindingViewModel : ViewModel() {
    val initTabAndPage : ObservableBoolean = ObservableBoolean()
    val pageAssetPath : ObservableField<String> = ObservableField()
}
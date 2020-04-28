package com.minlukj.wanandroid.brideg.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.brideg.state
 * @ClassName:      NavigationViewModel
 * @Description:    Navigation ViewModel
 * @Author:         忞鹿
 * @CreateDate:     2020/4/28 14:55
 */
class NavigationViewModel : ViewModel() {
    val buttonName = ObservableField<String>()
}
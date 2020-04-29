package com.minlukj.databinding.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.minlukj.databinding.entity.CarEntity

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.databinding.viewmodel
 * @ClassName:      AdvancedViewModel
 * @Description:    DataBinding + ViewModel
 * @Author:         忞鹿
 * @CreateDate:     2020/4/29 13:49
 */
class AdvancedViewModel : ViewModel() {
    val carEntity = ObservableField<CarEntity>()
    val initTabAndPage = ObservableBoolean(true)
}
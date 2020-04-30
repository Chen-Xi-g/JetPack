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
    //实体类使用 ObservableField<T>
    val carEntity = ObservableField<CarEntity>()
    //基本数据类型使用 ObservableInt、ObservableLong.... String属于ObservableField<T>
    val initTabAndPage = ObservableBoolean(true)
}
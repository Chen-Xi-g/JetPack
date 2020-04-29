package com.minlukj.databinding.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.minlukj.databinding.BR

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.databinding.entity
 * @ClassName:      ShopEntity
 * @Description:    DataBinding双向绑定实体类
 * @Author:         忞鹿
 * @CreateDate:     2020/4/29 13:13
 */
class ShopEntity() : BaseObservable() {
    constructor(name : String, address : String) : this(){
        this.name = name
        this.address = address
    }

    @Bindable
    var name  = ""
        set(value) {
            notifyPropertyChanged(BR.name)
            field = value
        }
        get() = field

    @Bindable
    var address = ""
        set(value) {
            notifyPropertyChanged(BR.address)
            field = value
        }
        get() = field
}
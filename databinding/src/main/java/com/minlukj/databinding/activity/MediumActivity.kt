package com.minlukj.databinding.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.minlukj.databinding.R
import com.minlukj.databinding.databinding.ActivityMediumBinding
import com.minlukj.databinding.entity.ShopEntity

/**
 * 中级DataBinding
 * 双向绑定
 */
class MediumActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMediumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_medium)
        val shopEntity = ShopEntity("北路店铺","北路")
        mBinding.entity = shopEntity
        mBinding.btnReset.setOnClickListener {
            shopEntity.name = "重置之后的北路店铺"
            shopEntity.address = "重置之后的北路"
        }
    }
}

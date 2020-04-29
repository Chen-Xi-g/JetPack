package com.minlukj.databinding.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.minlukj.databinding.R
import com.minlukj.databinding.databinding.ActivityBasisBinding
import com.minlukj.databinding.entity.CarEntity

/**
 * 基础DataBinding
 */
class BasisActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityBasisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_basis)
        val carEntity = CarEntity("宝马","防滑",true,100000,"八缸发动机")
        mBinding.entity = carEntity
    }
}
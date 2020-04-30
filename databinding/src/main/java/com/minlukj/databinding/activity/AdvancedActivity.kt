package com.minlukj.databinding.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minlukj.databinding.R
import com.minlukj.databinding.databinding.ActivityAdvancedBinding
import com.minlukj.databinding.entity.CarEntity
import com.minlukj.databinding.entity.ShopEntity
import com.minlukj.databinding.viewmodel.AdvancedViewModel

/**
 * 高级用法
 * DataBinding + BindingAdapter + ViewModel
 */
class AdvancedActivity : AppCompatActivity() {

    //Binding
    private lateinit var mBinding : ActivityAdvancedBinding
    //ViewModel
    private lateinit var mVm : AdvancedViewModel
    //实体类
    private lateinit var mShopEntity: ShopEntity
    private lateinit var mCarEntity: CarEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVm = ViewModelProvider(this,defaultViewModelProviderFactory).get(AdvancedViewModel::class.java)

        mShopEntity = ShopEntity("这是店铺的名字","这是店铺的地址")
        mCarEntity = CarEntity("宝马","防滑",true,100000,"八缸发动机")

        mVm.carEntity.set(mCarEntity)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_advanced)
        mBinding.vm = mVm
        mBinding.shopEntity = mShopEntity

        //修改ViewModel中数据
        mBinding.topBtnReset.setOnClickListener {
            //如果需要修改实体类值参照ShopEntity
            val mCarEntity2 = CarEntity("兰博基尼","PZero",true,System.currentTimeMillis(),"八十八缸发动机")
            mVm.carEntity.set(mCarEntity2)
        }

        //双向绑定
        mBinding.btnReset.setOnClickListener {
            mShopEntity.name = "重置之后的北路店铺${System.currentTimeMillis()}"
            mShopEntity.address = "重置之后的北路${System.currentTimeMillis()}"
        }
    }
}

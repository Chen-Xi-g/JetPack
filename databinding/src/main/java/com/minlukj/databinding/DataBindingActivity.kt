package com.minlukj.databinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.minlukj.databinding.activity.AdvancedActivity
import com.minlukj.databinding.activity.BasisActivity
import com.minlukj.databinding.activity.MediumActivity
import com.minlukj.databinding.databinding.ActivityDataBindingBinding

/**
 * DataBinding引导页
 */
class DataBindingActivity : AppCompatActivity() {

    private lateinit var mDataBinding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBinding初始化
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        mDataBinding.click = ClickProxy()
    }

    /**
     * 使用DataBinding设置点击事件
     */
    inner class ClickProxy{
        /**
         * 基础DataBinding
         */
        fun startBasisActivity(){
            startActivity(Intent(this@DataBindingActivity,BasisActivity::class.java))
        }

        /**
         * 中等DataBinding
         */
        fun startMediumActivity(){
            startActivity(Intent(this@DataBindingActivity,MediumActivity::class.java))
        }

        /**
         * 高级DataBinding
         */
        fun startAdvancedActivity(){
            startActivity(Intent(this@DataBindingActivity,AdvancedActivity::class.java))
        }
    }
}

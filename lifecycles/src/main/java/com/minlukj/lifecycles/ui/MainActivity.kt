package com.minlukj.lifecycles.ui

import android.content.Intent
import com.minlukj.lifecycles.R
import com.minlukj.lifecycles.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun initView() {
        setContentView(R.layout.activity_main)
        ac_btn_start_fragment.setOnClickListener {
            startActivity(Intent(this,FragmentActivity::class.java))
        }
    }
}

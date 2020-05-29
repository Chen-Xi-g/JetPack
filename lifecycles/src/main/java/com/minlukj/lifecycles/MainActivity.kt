package com.minlukj.lifecycles

import android.content.Intent
import com.minlukj.lifecycles.base.BaseActivity
import com.minlukj.lifecycles.ui.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun initView() {
        setContentView(R.layout.activity_main)
        ac_btn_start_fragment.setOnClickListener {
            startActivity(Intent(this,FragmentActivity::class.java))
        }
    }
}

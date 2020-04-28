package com.minlukj.wanandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 深夜模式适配
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btn_main_dialog.setOnClickListener {
      AlertDialog.Builder(this)
        .setTitle(getString(R.string.dialog_title))
        .setMessage(getString(R.string.dialog_msg))
        .setNegativeButton(getString(R.string.cancel),null)
        .setPositiveButton(getString(R.string.confirm)) { _, _ ->
          startActivity(Intent(this,DataBindingActivity::class.java))
        }
        .create().show()
    }
  }
}

package com.minlukj.wanandroid.badapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import com.minlukj.wanandroid.utils.Utils

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.wanandroid.badapter
 * @ClassName:      WebViewBindingAdapter
 * @Description:    WebView的BindingAdapter
 * @Author:         忞鹿
 * @CreateDate:     2020/4/27 11:02
 */
object WebViewBindingAdapter {

    @JvmStatic
    @SuppressLint("SetJavaScriptEnabled")
    @BindingAdapter(value = ["webAsset"], requireAll = false)
    fun loadAssetsPage(webView: WebView, assetPath: String?) {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                var uri: Uri? = null
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    uri = request.url
                }
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                Utils.getApp().startActivity(intent)
                return true
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                handler?.proceed()
//                super.onReceivedSslError(view, handler, error)
            }
        }
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.defaultTextEncodingName = "UTF-8"
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        val url = "file:///android_asset/$assetPath"
        webView.loadUrl(url)
    }

    @JvmStatic
    @SuppressLint("SetJavaScriptEnabled")
    @BindingAdapter(value = ["loadPage"], requireAll = false)
    fun loadPage(webView: WebView, loadPage: String?) {
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptCanOpenWindowsAutomatically = true//设置js可以直接打开窗口，如window.open()，默认为false
        webView.settings.javaScriptEnabled = true//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webView.settings.setSupportZoom(true)//是否可以缩放，默认true
        webView.settings.builtInZoomControls = true//是否显示缩放按钮，默认false
        webView.settings.useWideViewPort = true//设置此属性，可任意比例缩放。大视图模式
        webView.settings.loadWithOverviewMode = true//和setUseWideViewPort(true)一起解决网页自适应问题
        webView.settings.setAppCacheEnabled(true)//是否使用缓存
        webView.settings.domStorageEnabled = true//DOM Storage//
        webView.loadUrl(loadPage)
    }

}
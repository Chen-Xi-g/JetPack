package com.minlukj.lifecycles.observer

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.minlukj.lifecycles.observer.receiver.NetworkMonitor

/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles.observer
 * @ClassName:      NetworkManager
 * @Description:    网络监听的 LifecycleObserver
 * @Author:         忞鹿
 * @CreateDate:     2020/5/29 10:10
 */
class NetworkManager : DefaultLifecycleObserver {

    private val TAG = "NetworkManager"

    companion object{
        val instance : NetworkManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetworkManager()
        }
    }

    /**
     * 在onCreate中注册网络监听
     */
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        NetworkMonitor.instance.connectionStateMonitor()
        if (owner is AppCompatActivity) {
            NetworkMonitor.instance.enable(owner)
            Log.d(TAG,"Activity注册NetworkCallback")
        } else if (owner is Fragment) {
            NetworkMonitor.instance.enable(requireNotNull(owner.activity))
            Log.d(TAG,"Fragment注册NetworkCallback")
        }
    }

    /**
     * 在onDestroy中释放网络监听
     */
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        if (owner is AppCompatActivity){
            NetworkMonitor.instance.unregisterNetworkCallback(owner)
            Log.d(TAG,"Activity注销NetworkCallback")
        }else if (owner is Fragment){
            NetworkMonitor.instance.unregisterNetworkCallback(requireNotNull(owner.activity))
            Log.d(TAG,"Fragment注销NetworkCallback")
        }
    }
}
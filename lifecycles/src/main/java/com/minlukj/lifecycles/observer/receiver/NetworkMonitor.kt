package com.minlukj.lifecycles.observer.receiver

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log


/**
 *
 * @ProjectName:    WanAndroid
 * @Package:        com.minlukj.lifecycles.observer.receiver
 * @ClassName:      NetworkMonitor
 * @Description:    网络监听
 * @Author:         忞鹿
 * @CreateDate:     2020/5/29 10:32
 */
class NetworkMonitor : ConnectivityManager.NetworkCallback(){

    private val TAG = "NetworkMonitor"

    private lateinit var networkRequest: NetworkRequest

    companion object{
        val instance : NetworkMonitor by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetworkMonitor()
        }
    }

    fun connectionStateMonitor() {
        networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()
    }

    fun enable(context: Context) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    fun unregisterNetworkCallback(context: Context){
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.unregisterNetworkCallback(this)
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)){
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                // WIFI 已连接
                Log.d(TAG, "WIFI网络")
            }else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.d(TAG, "蜂窝网络")
            } else {
                Log.d(TAG, "其他网络")
            }
        }
    }

    /**
     * 网络连接
     */
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        Log.d(TAG,"网络已连接")
    }

    /**
     * 网络断开了
     */
    override fun onLost(network: Network) {
        super.onLost(network)
        Log.d(TAG,"网络已断开")
    }
}
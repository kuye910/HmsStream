package com.example.hmstream

import android.app.Application
import com.huawei.hms.maps.MapsInitializer


/*
@author MM.Li
@date 2021/6/25-10:20
*/



class HmsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 设置API Key
        MapsInitializer.setApiKey("CgB6e3x92lc703dKaH9bwKVbZ0Errs8plofpnQQa6UZayOwvmTpwIhjvkssHwzWq0YZpaXXMdyBWUhhHwFol2XVz")
    }
}
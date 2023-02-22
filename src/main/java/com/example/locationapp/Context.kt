package com.example.locationapp
import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.LocaleList
import com.google.android.material.internal.ContextUtils
import java.util.*

class Context(baseContext: Context) : ContextWrapper(baseContext){
    companion object{
        var language = "en"
        @SuppressLint("RestrictedApi")
        fun updateLocale(context: Context, localeToSwitch: Locale): com.example.locationapp.Context {
            var newContext = context
            val resources = context.resources
            val config = resources.configuration
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.N){
                val localelist = LocaleList(localeToSwitch)
                LocaleList.setDefault(localelist)
                config.setLocales(localelist)
            }   else{
                config.locale = localeToSwitch
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1){
                newContext = context.createConfigurationContext(config)
            }else{
                resources.updateConfiguration(config,resources.displayMetrics)
            }
            return Context(newContext)
        }
    }
}
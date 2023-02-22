package com.example.locationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnChangeVi: Button
    private lateinit var btnChangeEn: Button
    private lateinit var imageView: ImageView

    override fun attachBaseContext(newBase: android.content.Context?) {
        val localeToSwitch = Locale(Context.language)
        val localeUpdatedContext = newBase?.let{
            Context.updateLocale(it,localeToSwitch)
        }
        super.attachBaseContext(localeUpdatedContext)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnChangeVi = findViewById(R.id.btn_change_vi)
        btnChangeEn = findViewById(R.id.btn_change_en)
        imageView =  findViewById(R.id.imageView)

        btnChangeVi.setOnClickListener{
            changeLanguage(btnChangeVi)
            imageView.setImageResource(R.drawable.flagvn)

        }
        btnChangeEn.setOnClickListener{
            changeLanguage(btnChangeEn)
            imageView.setImageResource(R.drawable.flagen)

        }

    }

    private fun changeLanguage(view: View) {
       when(view){
           btnChangeVi ->{
                Context.language = "vi"
           }
           btnChangeEn ->{
             Context.language = "en"

           }
       }
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}
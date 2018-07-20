package com.example.yudizsolutionspvtltd.materialapp.login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.BottomAppbarBehaviourActivity
import com.example.yudizsolutionspvtltd.materialapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        next_button?.setOnClickListener {
            var iNavigation=Intent(this, BottomAppbarBehaviourActivity::class.java)
            startActivity(iNavigation)
        }
        changeStatusBarColor(this.getColor(android.R.color.white))

    }
    fun changeStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }
}

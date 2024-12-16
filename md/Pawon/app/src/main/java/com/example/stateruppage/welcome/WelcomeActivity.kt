package com.example.stateruppage.welcome

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stateruppage.login.LoginActivity
import com.example.stateruppage.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
  
  private lateinit var binding: ActivityWelcomeBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityWelcomeBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    playAnimation()
    transparentStatusBar()
    
    binding.button.setOnClickListener {
      val intent  = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }
    
  }
  
  private fun playAnimation() {
    ObjectAnimator.ofFloat(binding.fruitBackground, View.ROTATION, 0f, -360f).apply {
      duration = 100000 // 90 seconds full rotation
      repeatCount = ObjectAnimator.INFINITE
      repeatMode = ObjectAnimator.RESTART
    }.start()
  }
  
  private fun transparentStatusBar(){
    
    window.apply {
      decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
      statusBarColor = android.graphics.Color.TRANSPARENT
    }
    
  }
}
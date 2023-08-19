package com.example.myappbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myappbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, MenuFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.menu2 -> {
                    val intent = Intent(this@MainActivity, MenuActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
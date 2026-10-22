package com.example.pertemuan6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pertemuan6.ui.theme.Pertemuan6Theme
import com.example.pertemuan6.view.Navigasi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pertemuan6Theme {
                Navigasi()
            }
        }
    }
}
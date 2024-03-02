package com.example.parttwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.parttwo.Presentation.Login.LoginScreen
import com.example.parttwo.Presentation.Signup.SignupScreen
import com.example.parttwo.ui.theme.PartTwoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PartTwoTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    LoginScreen()
                }
            }
        }
    }
}

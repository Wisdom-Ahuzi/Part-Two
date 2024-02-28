package com.example.parttwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parttwo.Presentation.AuthenticationTemplate
import com.example.parttwo.Presentation.LoginScreen
import com.example.parttwo.Presentation.SignupScreen
import com.example.parttwo.ui.theme.PartTwoTheme

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

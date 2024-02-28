package com.example.parttwo.Presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parttwo.R

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationTemplate(
    intro : String,
    buttonText : String,
    otherScreen : String,
    isSignupScreen:Boolean
) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App logo",
            modifier = Modifier
                .weight(1f)
                .size(200.dp),
//            colorFilter = ColorFilter.tint(Color.White)
        )
        
        Card(
            modifier = Modifier
                .weight(2f)
                .padding(8.dp)
            ,
            shape = RoundedCornerShape(32.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Text(
                    text = intro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.text_medium),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = username,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        onValueChange = {username = it} ,
                        label = { Text(text = "Username")},
                        trailingIcon = {
                            if (username.isNotBlank()){
                                IconButton(onClick = { username = "" }) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear field icon")
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password,
                        onValueChange = {password = it} ,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        label = { Text(text = "Password")},
                        singleLine = true,
                        trailingIcon = {
                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                Icon(
                                    imageVector = if (isPasswordVisible) Icons.Default.Settings else Icons.Default.Home,
                                    contentDescription = "Clear field icon"
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        enabled = isFormValid,
                        shape = RoundedCornerShape(16.dp)
                        ,onClick = {

                        }
                    ) {
                        Text(
                            text = buttonText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorResource(id = R.color.text_medium)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (!isSignupScreen) Arrangement.SpaceBetween else Arrangement.Center
                        ) {
                        TextButton( onClick = { /*TODO*/ }) {
                             Text(
                                 text = otherScreen,
                                 style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                                 color = MaterialTheme.colorScheme.primary
                             )
                        }

                        if (!isSignupScreen){
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(
                                    text = "Forgot Password?",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                                    color = Color.Gray
                                )
                            }
                        }
                    }

                }
            }
        }
    }

}

@Preview
@Composable
fun SigninPreview(){
    AuthenticationTemplate(
        "Welcome back!",
        "Log in",
        "Sign up",
        false
    )
}
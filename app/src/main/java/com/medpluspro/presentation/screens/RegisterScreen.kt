package com.medpluspro.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medpluspro.R
import com.medpluspro.ui.theme.LoginBGColor
import com.medpluspro.ui.theme.PrimaryColor

@Composable
fun RegisterScreen(navController: NavController?) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Teal background color from the screenshot
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.login_placeholder),
                contentDescription = "Doctor image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = LoginBGColor,
                        shape = RoundedCornerShape(
                            topStart = 22.dp,
                            topEnd = 22.dp
                        ) // Rounded corners at the top
                    )
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Welcome",
                        fontSize = 24.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )
                    Text(
                        text = "Hello There! Register Here To Continue",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        placeholder = { Text("Full Name", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = PrimaryColor
                        )
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        placeholder = { Text("Mobile Number", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = PrimaryColor
                        )
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        placeholder = { Text("Email", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = PrimaryColor
                        )
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        placeholder = { Text("Password", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = PrimaryColor
                        )
                    )

                    Button(
                        onClick = { navController?.navigate("login") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryColor
                        )
                    ) {
                        Text(
                            text = "Register",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterScreen(null)
}
package com.medpluspro.presentation.screens

import android.text.Editable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.EditableText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medpluspro.R
import com.medpluspro.presentation.navigation.MedProPlusApp
import com.medpluspro.ui.theme.LoginBGColor
import com.medpluspro.ui.theme.PrimaryColor


@Composable
fun LoginScreen(navController: NavController?) {
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
                        text = "Hello There! Login Here to Continue",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth()
                            .padding(top = 16.dp)
                    ) {
                        // Subtitle
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Subtitle Image",
                            modifier = Modifier
                                .height(72.dp)
                                .padding(end = 16.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Subtitle Image",
                            modifier = Modifier
                                .height(72.dp)
                                .padding(start = 16.dp)
                        )
                    }

                    Text(
                        text = "OR",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp)
                    )
                    TextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        label = { Text("Mail or Mobile Number") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    TextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
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
                            text = "Login",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "Don't have an account? Create Account",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, start = 8.dp, end = 8.dp).clickable {
                                navController?.navigate("register")
                            }
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(null)
}
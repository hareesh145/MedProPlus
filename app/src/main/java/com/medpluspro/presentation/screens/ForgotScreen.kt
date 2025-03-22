package com.medpluspro.presentation.screens


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medpluspro.R
import com.medpluspro.ui.theme.LoginBGColor
import com.medpluspro.ui.theme.PrimaryColor

@Composable
fun ForgotScreen(navController: NavController?) {
    var selectedOption by remember { mutableStateOf("Email") }
    Box(
        modifier = Modifier
            .fillMaxSize() // Teal background color from the screenshot
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        IconButton(onClick = { /* Handle back navigation */ }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
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
                        text = "Forget Password",
                        fontSize = 24.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )
                    Text(
                        text = "Please select  option to  send link  to reset password",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    // Reset options
                    ResetOptionCard(
                        title = "Reset Via Email",
                        subtitle = "If Your Mail Is Linked To Account",
                        icon = Icons.Default.Email,
                        isSelected = selectedOption == "Email",
                        onClick = { selectedOption = "Email" }
                    )
                    ResetOptionCard(
                        title = "Reset Via SMS",
                        subtitle = "If Your Number Is Linked To Account",
                        icon = Icons.Default.Phone,
                        isSelected = selectedOption == "SMS",
                        onClick = { selectedOption = "SMS" }
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // Select Button
                    Button(
                        onClick = { /* Handle selection */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor) // Green
                    ) {
                        Text(text = "Select", fontSize = 16.sp, color = Color.White)
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotScreen(null)
}

@Composable
fun ResetOptionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val scale by animateFloatAsState(targetValue = if (isSelected) 1.05f else 1f, label = "")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    tint = Color(0xFF00C853),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
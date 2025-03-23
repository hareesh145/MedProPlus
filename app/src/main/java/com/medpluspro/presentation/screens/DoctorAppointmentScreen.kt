package com.medpluspro.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medpluspro.R

@Composable
fun DoctorAppointmentScreen(){
    val scrollState = rememberScrollState()
    val showContent by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFFF5F5F5))
    ) {
        AnimatedVisibility(visible = showContent, enter = fadeIn()) {
            DoctorProfileHeader()
        }
        AppointmentDetailsSection()
        PatientReviewsSection()
        BookAppointmentButton()
    }
}
@Composable
fun DoctorProfileHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.doctor_img),
            contentDescription = "Doctor",
            modifier = Modifier.size(100.dp),
            tint = Color.Unspecified
        )
        Text("Prof. Dr. Nissi Jhashva", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Dentist", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AppointmentDetailsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Enter Your Details", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        TextField(value = "", onValueChange = {}, label = { Text("Enter Your Full Name") })
        TextField(value = "", onValueChange = {}, label = { Text("Mobile Number") })
    }
}

@Composable
fun PatientReviewsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Patient Reviews", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun BookAppointmentButton() {
    Button(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("Book Appointment", fontSize = 18.sp)
    }
}

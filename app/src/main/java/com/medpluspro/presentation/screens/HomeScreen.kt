package com.medpluspro.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medpluspro.R
import com.medpluspro.ui.theme.LoginBGColor

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginBGColor)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Header Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Hello Nissi !", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Good Morning", fontSize = 14.sp, color = Color.Gray)
            }
            IconButton(onClick = { /* Handle notifications */ }) {
                BadgedBox(badge = { Badge { Text("1") } }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                }
            }
        }

        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            placeholder = { Text("Search") },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quick Actions
        QuickActionsSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Upcoming Appointments
        UpcomingAppointmentsSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Popular Doctors
        PopularDoctorsSection()
    }
}

@Composable
fun QuickActionsSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Quick Actions", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Show All", fontSize = 14.sp, color = Color.Green)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickActionItem("Doctor", Icons.Default.Person)
            QuickActionItem("Medicine", Icons.Default.Person)
            QuickActionItem("Report", Icons.Default.Person)
            QuickActionItem("Emergency", Icons.Default.Person)
        }
    }
}

@Composable
fun QuickActionItem(title: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(80.dp)
            .clickable { /* Handle click */ }
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
    ) {
        Icon(icon, contentDescription = title, modifier = Modifier.size(30.dp))
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun UpcomingAppointmentsSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Upcoming Appointment {5}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Show All", fontSize = 14.sp, color = Color.Green)
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF00C853)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.padding(12.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.doctor_img), // Replace with actual image
                    contentDescription = "Doctor",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Prof. Dr. Nissi Jhashva", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Dentist", fontSize = 14.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Person, contentDescription = "Date", tint = Color.White, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Feb - 25 - 2025", fontSize = 12.sp, color = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.Call, contentDescription = "Time", tint = Color.White, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("9:30 PM To 10:30 PM", fontSize = 12.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun PopularDoctorsSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Popular Doctor", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Show All", fontSize = 14.sp, color = Color.Green)
        }

        LazyColumn {
            items(2) { // Sample doctors list
                DoctorItem()
            }
        }
    }
}

@Composable
fun DoctorItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.doctor_img), // Replace with actual image
                contentDescription = "Doctor",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Prof. Dr. Nissi Jhashva", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Dentist", fontSize = 14.sp, color = Color.Gray)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = "Rating", tint = Color.Yellow, modifier = Modifier.size(16.dp))
                    Text("4.5 (230 Reviews)", fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("29$/Hr", fontSize = 12.sp, color = Color.Black)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Handle favorite click */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
            }
        }
    }
}

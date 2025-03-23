package com.medpluspro.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.medpluspro.R
import com.medpluspro.presentation.BottomNavItem

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(navController)
            }
            composable("schedules") {
                SchedulesScreen()
            }
            composable("messages") {
                MessagesScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
            composable("doctor_details"){
                DoctorAppointmentScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", R.drawable.ic_home, "Home"),
        BottomNavItem("schedules", R.drawable.ic_schedule, "Schedules"),
        BottomNavItem("messages", R.drawable.ic_message, "Messages"),
        BottomNavItem("profile", R.drawable.ic_profile, "Profile")
    )
    NavigationBar(
        containerColor = Color.White
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.route,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.route) },
                alwaysShowLabel = true
            )
        }
    }
}
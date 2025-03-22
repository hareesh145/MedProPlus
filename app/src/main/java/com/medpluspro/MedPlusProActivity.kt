package com.medpluspro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.medpluspro.presentation.navigation.MedProPlusApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MedPlusProActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Install the splash screen
        installSplashScreen()
        setContent {
            MedProPlusApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedProAppPreview() {
    MedProPlusApp()
}
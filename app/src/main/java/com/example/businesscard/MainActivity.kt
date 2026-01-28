package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                AllSection()
            }
        }
    }
}

@Composable
fun AllSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MainSection("MinHyung Lee", "Andrid Developer", painterResource(R.drawable.android_logo))
        }

        Column(
            modifier = Modifier.padding(bottom = 50.dp),
            horizontalAlignment = Alignment.Start
        ) {
            EmailSection("000-0000-0000", "abc@abcdefg", "abcdefg")
        }
    }
}

@Composable
fun MainSection(name: String, title: String, image: Painter, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color(0xFF073042),
            modifier = Modifier.size(120.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(
            text = name,
            fontSize = 45.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006D38)
        )
    }
}

@Composable
fun EmailSection(phoneNumber: String, email: String, instagram: String, modifier: Modifier = Modifier) {
    ContactRow(icon = Icons.Default.Call, text = phoneNumber)
    ContactRow(icon = Icons.Default.Email, text = email)
    ContactRow(icon = Icons.Default.Share, text = instagram)
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String){
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 16.sp,
            color = Color(0xFF073042)
        )
    }
}


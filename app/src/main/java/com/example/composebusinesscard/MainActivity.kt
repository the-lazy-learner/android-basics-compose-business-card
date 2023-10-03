package com.example.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = stringResource(R.string.user_name),
                        designation = stringResource(R.string.user_designation),
                        phone = stringResource(R.string.user_phone),
                        socialHandle = stringResource(R.string.user_social),
                        email = stringResource(R.string.user_email)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    designation: String,
    phone: String,
    socialHandle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val photo = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = modifier
            .background(color = Color(0xFFD2E8D4))
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = photo,
            contentDescription = "Profile photo",
            modifier = Modifier.height(96.dp)
        )
        Text(
            text = name,
            fontSize = 48.sp
        )
        Text(
            text = designation,
            color = Color(0xFF147442)
        )
        Spacer(modifier = Modifier.height(288.dp))
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "Phone",
                modifier = Modifier.padding(start = 40.dp)
            )
            Text(
                text = phone,
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
            )
        }
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "Social Handle"
            )
            Text(
                text = socialHandle,
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
            )
        }
        Row {
            Icon(
                Icons.Filled.Email,
                contentDescription = "Email",
                modifier = Modifier.padding(start = 64.dp)
            )
            Text(text = email, modifier = Modifier.padding(start = 16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    ComposeBusinessCardTheme {
        BusinessCard(
            name = stringResource(R.string.user_name),
            designation = stringResource(R.string.user_designation),
            phone = stringResource(R.string.user_phone),
            socialHandle = stringResource(R.string.user_social),
            email = stringResource(R.string.user_email)
        )
    }
}
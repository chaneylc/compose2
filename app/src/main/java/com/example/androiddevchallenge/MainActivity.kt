/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

//// Start building your app here!
@Composable
fun MyApp() {
    with(LocalContext.current) {

        Surface(Modifier.border(2.dp, purple, shape = shapes.large),
            color = MaterialTheme.colors.background, shape = shapes.large) {
            Image(painterResource(id = R.drawable.ic_welcome_bg),
                getString(R.string.main_welcome_bg_content_desc),
                Modifier.alpha(1.0f))
            Image(painterResource(id = R.drawable.ic_logo),
                getString(R.string.main_logo_content_desc),
                Modifier
                    .padding(16.dp)
                    .size(256.dp)
                    .alpha(0.79f),
                alignment = Alignment.Center,
                contentScale = ContentScale.Inside)
        }
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.Bottom) {

            Row(Modifier.padding(8.dp), verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center) {
                Button(onClick = {},
                    Modifier
                        .padding(8.dp)
                        .weight(1.0f),
                    shape = shapes.medium) {
                    Text(getString(R.string.get_started),
                        style = typography.button,
                        color = Color.Black)
                }
                Button(onClick = {},
                    Modifier
                        .background(colors.background)
                        .alpha(0.1f)
                        .padding(8.dp)
                        .weight(1.0f),
                    shape = shapes.medium) {
                    Text(getString(R.string.login), color = yellow)
                }
            }
        }

    }
}

@Composable
fun Login() {
    with(LocalContext.current) {

        Card(Modifier.fillMaxSize()) {

            Surface {
                Image(painterResource(id = R.drawable.ic_login_bg),
                    getString(R.string.main_welcome_bg_content_desc),
                    alignment = Alignment.TopCenter)
                Text(text = "Welcome",
                    Modifier.padding(16.dp, 128.dp),
                    style = typography.h3,
                    textAlign = TextAlign.Center,
                    //maxLines = 2,
                    //softWrap = true
                )
                Text(text = "back", //hehe
                    Modifier.padding(16.dp, 182.dp),
                    style = typography.h3,
                    textAlign = TextAlign.Center,
                )

            }

            Column(
                Modifier
                    .padding(8.dp), verticalArrangement = Arrangement.Bottom) {

                Row(Modifier.padding(2.dp), verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center) {
                    TextField("Email address", onValueChange = {},
                        Modifier
                            .padding(2.dp)
                            .requiredHeight(56.dp)
                            .weight(1.0f),
                        leadingIcon = { Icon(painterResource(id = android.R.drawable.ic_input_add),
                            getString(R.string.email_content_desc))})
                }
                Row(Modifier.padding(2.dp), verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center) {
                    TextField("Password", onValueChange = {},
                        Modifier
                            .padding(2.dp)
                            .requiredHeight(56.dp)
                            .weight(1.0f),
                        leadingIcon = { Icon(painterResource(id = android.R.drawable.ic_input_add),
                            getString(R.string.email_content_desc))})

                }
                Row(Modifier.padding(2.dp, 2.dp, 2.dp, 104.dp), verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {},
                        Modifier
                            .padding(2.dp)
                            .requiredHeight(48.dp)
                            .weight(1.0f),
                        shape = shapes.medium) {
                        Text(getString(R.string.login),
                            style = typography.button,
                            color = Color.Black)
                    }
                }
            }
        }
    }
}

//row of chips used in home page
//a horizontally scrollable row with buttons
//compose is awesome...but stll confusing a bit
@Composable
fun ChipRow(names: List<String>) {
    Row(Modifier.scrollable(ScrollState(0), Orientation.Horizontal)){
        names.forEach { chip ->
            Button(
                onClick = { },
                Modifier
                    .padding(16.dp)
                    .border(1.dp, Color.White)
                    .background(Color.Transparent)
                    .border(1.dp, color = Color.White), shape = shapes.medium
            ) {
                Text(
                    text = "Week", textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

// Start building your app here!
@Composable
fun Home() {
    with(LocalContext.current) {

        Card(
            Modifier
                .fillMaxSize()
                .scrollable(ScrollState(0), Orientation.Vertical), backgroundColor = colors.background) {

            Column(Modifier.fillMaxSize()) {

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {

                    Text(text = "Account",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        textAlign = TextAlign.Start,
                    )
                    Text(text = "Watchlist",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        style = typography.body1, textAlign = TextAlign.Center,
                    )
                    Text(text = "Profile",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        style = typography.body1, textAlign = TextAlign.End,
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Balance",
                        Modifier
                            .padding(16.dp)
                            .weight(1.0f),
                        style = typography.h6, textAlign = TextAlign.Center,
                        color = white,
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(text = "$18,920.07",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        style = typography.h2, textAlign = TextAlign.Center,
                        color = white,
                    )
                }

                //use today's diff as variable to switch between red/green
                val localDiff = rememberSaveable { mutableStateOf(-42.29)}
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {
                    Text(
                        text = "${localDiff.value} today",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        style = typography.h6, textAlign = TextAlign.Center,
                        color = if (localDiff.value > 0) colors.primaryVariant
                        else colors.secondaryVariant,
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Button(onClick = {  },
                        Modifier
                            .padding(16.dp)
                            .weight(1.0f), shape = shapes.medium) {
                        Text(text = "Transact", textAlign = TextAlign.Center,
                            color = Color.Black)
                    }
                }

                ChipRow(listOf("Week", "ETFs", "Stocks", "Funds", "...Cats"))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(id = R.drawable.ic_home_illos),
                        getString(R.string.main_welcome_bg_content_desc),
                        alignment = Alignment.Center)
                }

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {  },
                        Modifier
                            .weight(1.0f)
                            .background(colors.primary)) {
                        Text(text = "Positions",
                            Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Black)
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

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
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.transparent
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.yellow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(false)
                Login(false)
                Home(true)
            }
        }
    }
}

// // Start building your app here!
@Composable
fun MyApp(visible: Boolean) {

    with(LocalContext.current) {

        Surface(
            Modifier
                .fillMaxSize()
                .alpha(if (visible) 1f else 0f)
                .border(2.dp, purple, shape = shapes.large),
            color = MaterialTheme.colors.background, shape = shapes.large
        ) {
            Image(
                painterResource(id = R.drawable.ic_welcome_bg),
                getString(R.string.main_welcome_bg_content_desc),
                Modifier.alpha(1.0f)
            )
            Image(
                painterResource(id = R.drawable.ic_logo),
                getString(R.string.main_logo_content_desc),
                Modifier
                    .padding(16.dp)
                    .size(256.dp)
                    .alpha(0.79f),
                alignment = Alignment.Center,
                contentScale = ContentScale.Inside
            )
        }
        Column(
            Modifier
                .padding(8.dp)
                .alpha(if (visible) 1f else 0f),
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                Modifier.padding(8.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    Modifier
                        .weight(1.0f)
                        .padding(0.dp, 0.dp, 16.dp, 0.dp),
                    shape = shapes.medium
                ) {
                    Text(
                        getString(R.string.get_started),
                        style = typography.button,
                        color = Color.Black
                    )
                }
                Button(
                    onClick = {},
                    Modifier
                        // this border doesn't line up with the button
                        .border(1.dp, colors.primary, shape = shapes.medium)
                        .background(transparent)
                        .weight(1.0f)
                        .padding(16.dp, 0.dp, 0.dp, 0.dp),
                    shape = shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = transparent,
                    )
                ) {
                    Text(
                        getString(R.string.login),
                        color = yellow,
                        style = typography.button
                    )
                }
            }
        }
    }
}

@Composable
fun Login(visible: Boolean) {

    with(LocalContext.current) {

        Card(
            Modifier
                .fillMaxSize()
                .alpha(if (visible) 1f else 0f)
        ) {

            Surface {
                Image(
                    painterResource(id = R.drawable.ic_login_bg),
                    getString(R.string.main_welcome_bg_content_desc),
                    alignment = Alignment.TopCenter
                )
                Text(
                    text = "Welcome",
                    Modifier.padding(16.dp, 128.dp),
                    style = typography.h3,
                    textAlign = TextAlign.Center,
                    // maxLines = 2,
                    // softWrap = true
                )
                Text(
                    text = "back", // hehe
                    Modifier.padding(16.dp, 182.dp),
                    style = typography.h3,
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.Bottom
            ) {

                Row(
                    Modifier
                        .padding(2.dp)
                        .background(transparent),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        "Email address", onValueChange = {},
                        Modifier
                            .padding(2.dp)
                            .background(transparent)
                            .requiredHeight(56.dp)
                            .weight(1.0f),
                        leadingIcon = {
                            Icon(
                                painterResource(id = R.drawable.ic_mail_outline_24px),
                                getString(R.string.email_content_desc)
                            )
                        }
                    )
                }
                Row(
                    Modifier
                        .padding(2.dp)
                        .background(transparent),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        "Password", onValueChange = {},
                        Modifier
                            .padding(2.dp)
                            .background(transparent)
                            .requiredHeight(56.dp)
                            .weight(1.0f),
                        leadingIcon = {
                            Icon(
                                painterResource(id = R.drawable.ic_password_24px),
                                getString(R.string.email_content_desc)
                            )
                        }
                    )
                }
                Row(
                    Modifier.padding(2.dp, 2.dp, 2.dp, 116.dp), verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {},
                        Modifier
                            .padding(0.dp, 16.dp, 0.dp, 0.dp)
                            .requiredHeight(48.dp)
                            .weight(1.0f),
                        shape = shapes.medium
                    ) {
                        Text(
                            getString(R.string.login),
                            style = typography.button,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StockList(visible: Boolean, stocks: List<Stock>) {
    Column(
        Modifier
            .wrapContentHeight()
            .background(colors.surface)
            .alpha(if (visible) 1f else 0f)
            .verticalScroll(ScrollState(0), true)
    ) {
        stocks.forEach { stock ->
            Divider()
            StockRow(stock)
            Divider()
        }
    }
}

@Composable
fun StockRow(stock: Stock) {

    Row(Modifier.padding(8.dp)) {
        Column(Modifier.weight(1f)) {
            Row {
                Text(stock.current, style = typography.h3)
            }
            Row {
                Text(
                    "${stock.diff}%",
                    style = typography.body2,
                    color = if (stock.diff < 0) colors.primaryVariant
                    else colors.secondaryVariant
                )
            }
        }
        Column(Modifier.weight(3f)) {

            Row {
                Text(
                    stock.alias,
                    color = colors.onSurface,
                    style = typography.body2
                )
            }

            Row {
                Text(
                    stock.name,
                    color = colors.onSurface,
                    style = typography.body2
                )
            }
        }
        Column(Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = stock.resource),
                contentDescription = ""
            )
        }
    }
}

// row of chips used in home page
// a horizontally scrollable row with buttons
// compose is awesome...but stll confusing a bit
// sometimes this shows as wrapped content sometimes it fits to width....
@Composable
fun ChipList(names: List<String>) {
    Row(
        Modifier
            .wrapContentWidth()
            .horizontalScroll(ScrollState(0), true)
    ) {
        names.forEachIndexed { index, chip ->
            ChipColumn(index, chip)
        }
    }
}

// give index 1 an icon
@Composable
fun ChipColumn(index: Int, name: String) {
    Button(
        onClick = { },
        Modifier
            .wrapContentWidth()
            .padding(8.dp, 0.dp)
            .border(1.dp, color = Color.White, shape = shapes.medium),
        shape = shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = transparent,
        )
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            color = Color.White,

        )
    }
}

// Start building your app here!
@Composable
fun Home(visible: Boolean) {
    with(LocalContext.current) {

        Card(
            Modifier
                .alpha(if (visible) 1f else 0f)
                .fillMaxSize()
                .scrollable(ScrollState(0), Orientation.Vertical),
            backgroundColor = colors.background
        ) {

            Column(
                Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(unbounded = true)
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {

                    Text(
                        text = "Account",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        textAlign = TextAlign.Start,
                        style = com.example.androiddevchallenge.ui.theme.typography.button
                    )
                    Text(
                        text = "Watchlist",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f)
                            .alpha(0.5f),
                        style = com.example.androiddevchallenge.ui.theme.typography.button,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Profile",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f)
                            .alpha(0.5f),
                        style = com.example.androiddevchallenge.ui.theme.typography.button,
                        textAlign = TextAlign.End,
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Balance",
                        Modifier
                            .padding(16.dp)
                            .weight(1.0f),
                        style = typography.subtitle1,
                        textAlign = TextAlign.Center,
                        color = white,
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "$18,920.07",
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        style = typography.h2, textAlign = TextAlign.Center,
                        color = white,
                    )
                }

                // use today's diff as variable to switch between red/green
                val localDiff = rememberSaveable { mutableStateOf(-42.29) }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
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
                    Button(
                        onClick = { },
                        Modifier
                            .padding(8.dp)
                            .weight(1.0f),
                        shape = shapes.medium
                    ) {
                        Text(
                            text = "Transact", textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    }
                }

                ChipList(listOf("Week", "ETFs", "Stocks", "Funds", "...Cats"))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_home_illos),
                        getString(R.string.main_welcome_bg_content_desc),
                        alignment = Alignment.Center
                    )
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .requiredSize(512.dp, 100.dp)
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { }, Modifier.weight(1.0f),
                        shape = shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = white
                        )
                    ) {
                        Text(
                            text = "Positions",
                            Modifier.fillMaxWidth(),
                            style = typography.button,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

// quick class to represent the list item
data class Stock(val current: String, val diff: Double, val name: String, val alias: String, val resource: Int)

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val stocks = listOf(
        Stock("$7,918", -0.54, "Alaska Air Group, Inc.", "ALK", R.drawable.ic_home_alk),
        Stock("$1,293", 4.18, "Boeing Co.", "BA", R.drawable.ic_home_ba),
        Stock("$893.50", -0.54, "Delta Airlines Inc.", "DAL", R.drawable.ic_home_dal),
        Stock("$12,301", 2.51, "Expedia Group Inc.", "EXPE", R.drawable.ic_home_exp),
        Stock("$12,301", 1.38, "Airbus SE", "EADSY", R.drawable.ic_home_eadsy),
        Stock("$8,521", 1.56, "Jetblue Airways Corp.", "JBLU", R.drawable.ic_home_jblu),
        Stock("$521", 2.75, "Marriot International Inc.", "MAR", R.drawable.ic_home_mar),
        Stock("$5,481", 0.14, "Carnival Corp", "CCL", R.drawable.ic_home_ccl),
        Stock("$9,184", 1.69, "Royal Caribbean Cruises", "RCL", R.drawable.ic_home_rcl),
        Stock("$1", -0.42, "CC App Development", "CLC", R.drawable.ic_home_trvl),
    )
    MyTheme {
        MyApp(false)
        Login(false)
        Home(false)
        StockList(true, stocks)
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val stocks = listOf(
        Stock("$7,918", -0.54, "Alaska Air Group, Inc.", "ALK", R.drawable.ic_home_alk),
        Stock("$1,293", 4.18, "Boeing Co.", "BA", R.drawable.ic_home_ba),
        Stock("$893.50", -0.54, "Delta Airlines Inc.", "DAL", R.drawable.ic_home_dal),
        Stock("$12,301", 2.51, "Expedia Group Inc.", "EXPE", R.drawable.ic_home_exp),
        Stock("$12,301", 1.38, "Airbus SE", "EADSY", R.drawable.ic_home_eadsy),
        Stock("$8,521", 1.56, "Jetblue Airways Corp.", "JBLU", R.drawable.ic_home_jblu),
        Stock("$521", 2.75, "Marriot International Inc.", "MAR", R.drawable.ic_home_mar),
        Stock("$5,481", 0.14, "Carnival Corp", "CCL", R.drawable.ic_home_ccl),
        Stock("$9,184", 1.69, "Royal Caribbean Cruises", "RCL", R.drawable.ic_home_rcl),
        Stock("$1", -0.42, "CC App Development", "CLC", R.drawable.ic_home_trvl),
    )
    MyTheme(darkTheme = true) {
        MyApp(false)
        Login(false)
        Home(false)
        StockList(true, stocks)
    }
}

package com.example.baitapbuoi4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitapbuoi4.ui.theme.BaiTapBuoi4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapBuoi4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetlayoutPreview()
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: String) {
    Text(
        text = "Hello, $msg!",
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth(),
        color = Color.DarkGray,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
    TextWithSize(msg,30.sp)
}

@Composable
fun GreetingPreview() {
    BaiTapBuoi4Theme {
        MessageCard("Lê Đăng Sang - PH42693")
    }
}

@Composable
fun GreetingCard(msg: String) {
    var text by remember { mutableStateOf(msg) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard(msg = text)
        Button(onClick = { text = "Nice to meet you!" }) {
            Text("Say Hi!")
        }
        CounterCard()
        SelectableText()
    }
}

@Composable
fun CounterCard() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard("You have clicked the button $count times.")
        Button(onClick = { count++ }) {
            Text("Click me")
        }
    }
}

@Composable
fun TextWithSize(lable : String, size : TextUnit){
    Text(text = lable.repeat(50),
        fontSize = size, // kích thước
        color = Color.Green, // màu
        fontWeight = FontWeight.Bold, // độ đậm của chữ
        fontStyle = FontStyle.Italic, // kiểu chữ
        maxLines = 2, // giới hạn số dòng
        overflow = TextOverflow.Ellipsis // hiển thị ... khi nội dung quá dài
    )
}

// Bật chế độ cho phép copy
@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}

@Composable
fun GetLayout(title:String, innerPadding: Dp){
    Text(
        title,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
        fontSize = 30.sp,
        color = Color.Red,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GetlayoutPreview(){
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        GetLayout(title = count.toString(), innerPadding = 10.dp)
        Button(onClick = { count++
        }) {
            Text(text = "Tăng")
        }
        Button(onClick = { count--
        }) {
            Text(text = "Giảm")
        }
    }
}


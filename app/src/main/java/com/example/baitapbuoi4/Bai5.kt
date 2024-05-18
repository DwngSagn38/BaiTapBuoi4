package com.example.baitapbuoi4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.IdRes
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.compose.AsyncImage

class Bai5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout()
        }
    }
}

@Preview
@Composable
fun GetLayout () {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(10.dp).fillMaxWidth()
    ){
        GetTextTitle(title = "Thanh Toán")

        GetAddress(name = "Lê Đăng Sang", phone = "0345836201", address = "Hòa Hải - Hương Khê - Hà Tĩnh")

        GetRowItem(color = Color.Yellow, R.drawable.ic_paypal, "Paypal")
        GetRowItem(color = Color.White, R.drawable.ic_visa, "Visa")
        GetRowItem(color = Color.Magenta, R.drawable.ic_momo, "Momo")
        GetRowItem(color = Color.Blue, R.drawable.ic_zalopay, "Zalo Pay")
        GetRowItem(color = Color.Cyan, R.drawable.ic_cost, "Thanh toán trực tiếp")
    }
    ButtonWithColor()
    NaviBottom()

}

@Composable
fun ButtonWithColor(){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 680.dp, 20.dp, 20.dp)
            .size(60.dp),
        onClick = {

    },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red))
    {
        Text(text = "Tiếp theo",color = Color.White,fontWeight = FontWeight.Bold,
            fontSize = 18.sp)
    }
}

//fun GetRowItem (color: Color, linkImage: String, noidungtext: String)
@Composable
fun GetRowItem (color: Color, IdImage : Int , noidungtext: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .background(color = color, shape = RoundedCornerShape(15.dp))
            .height(80.dp)
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(15.dp))
    ) {
            Image(
                painter = painterResource(id = IdImage),
                contentDescription = "ten anh",
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(7.dp)
                    .size(50.dp)
            )


//        AsyncImage(
//            model = linkImage,
//            modifier = Modifier
//                .width(60.dp)
//                .padding(5.dp),
//            contentDescription = null
//        )

        Text(
            text = noidungtext,
            modifier = Modifier
                .weight(1f)
                .padding(50.dp, 0.dp, 0.dp, 0.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}

@Composable
fun GetTextTitle (title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 30.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun GetAddress(name : String, phone : String, address : String){
    Column {
        Text(text = "Địa chỉ nhận hàng", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp,20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = "map",
                modifier = Modifier
                    .size(50.dp))

            Text(text = "$name | $phone \n$address", fontSize = 14.sp, fontWeight = FontWeight(400),
                modifier = Modifier.padding(30.dp,0.dp))
        }

        Text(text = "Vui lòng chọn một những phương thức sau : ",
            fontSize = 15.sp, fontWeight = FontWeight(500),
            modifier = Modifier.padding(10.dp,0.dp,0.dp, 30.dp))
    }
}

@Composable
fun NaviBottom(){
    Row (
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(20.dp).fillMaxHeight().fillMaxWidth()
    ){
        ItemNav(IdImage = R.drawable.home, itemName = "Trang chủ", Color.Black)
        ItemNav(IdImage = R.drawable.ic_bill, itemName = "Lịch sử", Color.Black)
        ItemNav(IdImage = R.drawable.ic_cart, itemName = "Giỏ hàng", Color.Red)
        ItemNav(IdImage = R.drawable.user, itemName = "Hồ sơ",Color.Black)
    }
}

@Composable
fun ItemNav(IdImage: Int, itemName : String, color: Color){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(18.dp,0.dp)
    ) {
        Image(painter = painterResource(id = IdImage), contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .padding(7.dp),
            colorFilter = ColorFilter.tint(color)
            )


        Text(text = itemName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = color)
    }
}





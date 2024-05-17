package duypvph46.fpoly.lab3_md18306

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class Bai5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout()

        }
    }

}
@Preview(showBackground = true)
@Composable
fun GetLayout(title: String = "Thanh Toán") {
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start, // Align to the start (left)
        modifier = Modifier.padding(10.dp)
    ){
        // Content
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Header
            Text(
                text = "Thanh Toán",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 30.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center // Align to the start (left)
            )

            Text(
                text = "Địa chỉ nhận hàng",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp), // Padding on the left and top
                fontSize = 16.sp,
                color = Color.Gray
            )

            // Địa chỉ nhận hàng
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp) // Padding on the left
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vitri), // Thay your_image_resource bằng ID của ảnh của bạn
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(20.dp) // Kích thước của ảnh
                        .padding(end = 8.dp) // Khoảng cách giữa ảnh và văn bản
                )

                Text(
                    text = "Phùng Văn Duy 136 Thôn Thanh Vị Xã Thanh Sơn Tây Hà Nội",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Vui lòng nhập phương thức",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp), // Padding on the left and top
                fontSize = 16.sp,
                color = Color.Gray
            )

            // List thanh toán
            GetRowItem(color = Color.Yellow, linkImage = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png", noidungtext = "PayPal")
            GetRowItem(color = Color.Cyan, linkImage = "https://gcs.tripi.vn/public-tripi/tripi-feed/img/475223TdJ/anh-mo-ta.png", noidungtext = "MoMo")
            GetRowItem(color = Color.Magenta, linkImage = "https://images2.thanhnien.vn/528068263637045248/2023/2/15/bong-da-sv-2aa-16764457958392020821477.jpg", noidungtext = "Zalo Pay")
            GetRowItem(color = Color.DarkGray, linkImage = "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2023/3/20/1159566/Bong-Da-Phui.jpg", noidungtext = "VN Pay")
        }

        // Button and Bottom Navigation Bar
        Button(
            onClick = { /* Xử lý khi nút được nhấn */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFA500)) // Màu nền cam
        ) {
            Text(
                text = "Tiếp Theo",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }

        BottomNavigationBar()




    }
}

@Composable
fun BottomNavigationBar() {
   Column {
       Row(
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .background(
                   color = Color.Black,
                   shape = RoundedCornerShape(10.dp)
               )
               .height(5.dp)
               .fillMaxWidth()
       ) {

       }
       Row (verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceEvenly,
           modifier = Modifier
               .padding(10.dp)
               .fillMaxWidth()){
                NavigationItem(R.drawable.home,"Trang Chủ")
                NavigationItem(R.drawable.ghichu,"Lịch Sử")
                NavigationItem(R.drawable.thanhtoan,"Thanh Toán")
                NavigationItem(R.drawable.hoso,"Hồ Sơ")

       }
   }

}

@Composable
fun NavigationItem(image : Int,title: String){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = image), contentDescription = null,
            Modifier
                .height(30.dp)
                .width(30.dp))
        Text(text = title, color = Color.Black, modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp))
    }


}

@Composable
fun GetRowItem(color: Color, linkImage: String, noidungtext: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .background(color = color, shape = RoundedCornerShape(15.dp))
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(linkImage),
            contentDescription = "Payment Method",
            modifier = Modifier
                .width(60.dp)
                .padding(5.dp)
        )

        Text(
            text = noidungtext,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
            color = Color.White
        )

        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}

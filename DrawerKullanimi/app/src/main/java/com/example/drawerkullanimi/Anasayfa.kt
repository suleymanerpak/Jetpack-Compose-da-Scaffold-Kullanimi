package com.example.drawerkullanimi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)// Drawer'ın başlangıç durumu kapalı (Closed) olarak ayarlanıyoruz.
    val coroutineScope = rememberCoroutineScope()
    //Coroutine'leri başlatmak ve yönetmek için bir coroutine scope oluşturuyoruz. Bu satır asenkron işlemler yapmamıza olanak tanıyor.

    //Drawer arka plan rengi durumu
    val drawerBackgroundColor by remember {
        derivedStateOf {
            if (drawerState.isClosed) Color.Transparent else Color.Magenta
            //Eğer drawer kapalıysa arka plan rengi şeffaf, açıksa magenta rengi olacak.
        }
    }
    //ModalNavigationDrawer bileşenini kullanarak bir drawer yapısı oluşturuyoruz.
    ModalNavigationDrawer(
        drawerState = drawerState, //Drawer durumunu kontrol ediyoruz.
        drawerContent = {
            //Drawer genişliğini ayarlamak için Box yapısını kullanılıyoruz.
            Box(
                modifier = Modifier
                    .width(250.dp) //Drawer'ın genişliğini 250 dp olarak ayarlıyoruz.
                    .fillMaxHeight() //Drawer ekranın tamamını kaplayacak kadar yüksek olacak.
                    .background(Color.Magenta) //Drawer'ın arka plan rengini magenta olarak ayarlıyoruz.
            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize() //Column drawer içindeki tüm alanı kaplayacak.
                    .background(drawerBackgroundColor) //Arka plan rengi başlangıçta şeffaf, açıldığında magenta olacak.
            ) {
                Text(text = "İçerik 1 ",
                    style = TextStyle(fontSize = 24.sp, color = Color.White),
                    modifier = Modifier
                        .clickable {
                            coroutineScope.launch { drawerState.close() }  //Tıklandığında drawer'ı kapatmak için coroutine kullanılıyoruz.
                        }.padding(16.dp)
                )
                Text(text = "İçerik 2",
                    style = TextStyle(fontSize = 24.sp, color = Color.White),
                    modifier = Modifier.clickable { coroutineScope.launch { drawerState.close() } }.padding(16.dp)
                )
            }
            }
        },
                scrimColor = Color.Transparent //Drawer açıldığında arka planda görünen alan şeffaf olacak.
    ) {
        Scaffold(
            topBar = {
                TopAppBar( title = { Text("Drawer Örneği") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() } //Menü simgesine tıklandığında drawer açılacak.
                        }) { Icon(Icons.Filled.Menu, contentDescription = null) } // Menü simgesi kullanılarak drawer kontrolü sağlanıyor.
                        },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF6200EE), //AppBar yani üst çubuğun arka plan rengini mor yapıyoruz.
                        titleContentColor = Color.White //Başlık metninin rengini beyaz olarak ayarlıyoruz.
                    ),
                    modifier = Modifier.shadow(8.dp) //Üst çubuğa 8 dp'lik bir gölge efekti veriyoruz.
                )
            },
            content = { paddingValues ->
                //Scaffold içeriği burada tanımlanır. Padding değerlerini alıp uygular.
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Ana İçerik", fontSize = 24.sp, color = Color.Black)
                }
            }
        )
    }
}
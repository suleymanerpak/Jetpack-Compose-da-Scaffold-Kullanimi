package com.example.scaffoldkullanimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldKullanimi(){
    Scaffold(
        topBar = { //Scaffold içerisine topBar parametresi ekleyerek üstteki çubuğu tanımlıyoruz.
        TopAppBar(
            title = { Text("Top App Bar Örneği") }, //Üst çubuğun başlığı olarak "Top App Bar Örneği" metnini tanımlıyoruz.
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Red, //Üst çubuğun arka plan rengini kırmızı olarak ayarlıyoruz.
                titleContentColor = Color.White //Başlık metninin rengini beyaz olarak ayarlıyoruz.
            ),
            actions = {// Üst çubukta sağda bulunan eylemler için bir actions tanımlıyoruz.
                IconButton(onClick = {}) {//Üzerine tıklandığında hiçbir işlem yapmayan bir IconButton oluşturuyoruz.
                    Icon(Icons.Default.AccountCircle, contentDescription = "Kullanici") //Icon olarak varsayılan AccountCircle simgesini kullanıyoruz.
                }
            }
        )
    },
        bottomBar = { //Scaffold'ın alt kısmında bir bottomBar tanımlıyoruz.
            BottomAppBar {//Alt çubuk olarak BottomAppBar bileşenini kullanıyoruz.
                NavigationBarItem(
                    selected = true, //Bu işlemin bu sayfada seçili olduğunu tanımlıyoruz.
                    onClick = { /*TODO*/ },
                    icon = { Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Shopping Cart",)
                    },
                    label = {Text(text = "Sepet")} // Bu item için etiket olarak "Sepet" metnini kullanıyoruz.
                )
                NavigationBarItem(
                    selected = false, //Bu işlemin bu sayfada seçili olmadığını tanımlıyoruz.
                    onClick = { /*TODO*/ },
                    icon = { Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",)
                    },
                    label = {Text(text = "Favoriler")}
                )
                NavigationBarItem(selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",)
                    },
                    label = {Text(text = "Ayarlar")}
                )
            }
        },
        floatingActionButton = { //Scaffold'ın içinde bir FloatingActionButton tanımlıyoruz.
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color(0xFF6200EE), //FAB'ın arka plan rengini mor olarak ayarlıyoruz.
                contentColor = Color.White, //FAB üzerindeki ikonun rengini beyaz olarak ayarlıyoruz.
                modifier = Modifier.size(56.dp)) //FAB'ın boyutunu 56 dp olarak ayarlıyoruz.
            {
                Icon(
                    imageVector = Icons.Filled.Add, //FAB üzerindeki ikonda "Ekle" olarak "Add" simgesini kullanıyoruz.
                    contentDescription = "Add", //İkonun erişilebilirlik açıklamasını "Add" olarak belirliyoruz.
                )
            }
        },
        )
    {paddingValues -> //Lambda ifadesi, Scaffold'ın içerik alanına padding değerlerini sağlar.
        Column(modifier = Modifier
            .fillMaxSize() //Column bileşeninin tüm mevcut alanı kaplamasını sağlar.
            .padding(paddingValues),//Padding değeri tasarım alanının app bar altında kalmasını engeller. Scaffold'dan alınan padding değerlerini Column bileşenine uygular.
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly)
        {
            Text(text = "Content (İçerik) Kısmı", fontSize = 24.sp, color = Color.Black)
        }
    }
}
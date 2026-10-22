package com.example.pertemuan6.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    nama: String,
    gender: String,
    alamat: String,
    onBackBtnClick: () -> Unit
) {
    val items = listOf(
        "NAMA LENGKAP" to nama,
        "JENIS KELAMIN" to gender,
        "ALAMAT" to alamat
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tampilan Data", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            items.forEach { (label, value) ->
                Text(
                    text = label,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = value,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = Color(0xFF26C6DA)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackBtnClick
            ) {
                Text(text = "Back")
            }
        }
    }
}
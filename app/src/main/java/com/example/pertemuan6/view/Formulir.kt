package com.example.pertemuan6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitBtnClick: () -> Unit
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home), // isi: "Form Isian"
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nama Lengkap
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                singleLine = true,
                label = { Text(text = "Nama Lengkap") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Jenis kelamin (radio button sejajar, selebar kolom)
            Row(
                modifier = Modifier.width(250.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = gender == item,
                            onClick = { gender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Alamat
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                singleLine = true,
                label = { Text(text = "Alamat") },
                modifier = Modifier.width(250.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

 
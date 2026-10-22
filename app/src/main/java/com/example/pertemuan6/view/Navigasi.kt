package com.example.pertemuan6.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Halaman {
    Formulir,
    Tampil
}

@Composable
fun Navigasi() {
    val navController = rememberNavController()

    var nama by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = Halaman.Formulir.name
    ) {
        composable(route = Halaman.Formulir.name) {
            FormIsian(
                onSubmitBtnClick = { n, g, a ->
                    nama = n
                    gender = g
                    alamat = a
                    navController.navigate(Halaman.Tampil.name)
                }
            )
        }

        composable(route = Halaman.Tampil.name) {
            TampilData(
                nama = nama,
                gender = gender,
                alamat = alamat,
                onBackBtnClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
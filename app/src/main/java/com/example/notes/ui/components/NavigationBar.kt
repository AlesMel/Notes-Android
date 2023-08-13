package com.example.notes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import com.example.notes.R

@Composable
private fun BackButton() {
    ResizedNavigationButtons({}, R.drawable.back_arrow, 24.dp, 24.dp)
}

@Composable()
private fun HomeButton() {
    ResizedNavigationButtons({}, R.drawable.home_icon, 24.dp, 24.dp)
}

@Composable
fun NavigationButtons(title: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // Odsazení mezi tlačítky
    ){
        BackButton()
        Text(title, fontSize= 26.sp)
        HomeButton()
    }
}


@Composable
private fun ResizedNavigationButtons(onClick: () -> Unit, imageResId: Int, width: Dp, height: Dp) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .size(width = width, height = height)
            .clickable(onClick = onClick)
    )
}
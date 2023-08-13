package com.example.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.notes.R

@Composable
fun BottomNavigationBar() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.List,
        BottomNavItem.Analytics,
        BottomNavItem.Profile
    )

    NavigationBar (
        containerColor = Color.Transparent,
        contentColor = Color.Transparent
    ) {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        label = {
            Text(screen.title)
        },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title,
                tint = Color.Black,
                modifier = Modifier.size(16.dp),
            )
        },
        selected = true,
        alwaysShowLabel = false,
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White) // Barva pozadí
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    )
}

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.home
        )

    object List :
        BottomNavItem(
            "List",
            R.drawable.home
        )

    object Analytics :
        BottomNavItem(
            "Analytics",
            R.drawable.home
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.home
        )
}

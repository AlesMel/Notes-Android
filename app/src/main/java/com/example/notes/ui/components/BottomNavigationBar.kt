package com.example.notes.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.notes.R

@Composable
fun BottomNavigationBar() {

    val items = listOf(
        BottomNavItem.Notes,
        BottomNavItem.Home,
        BottomNavItem.Settings
    )

    var selectedItem by remember { mutableStateOf(items[1]) }

    NavigationBar (
        containerColor  = colorResource(id = R.color.BottomNavigationBarIconColor),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    ) {
        items.forEach { item ->
            AddItem(
                screen = item,
                selected = item == selectedItem,
                onItemSelected = { isSelected ->
                    if (isSelected) {
                        selectedItem = item
                    }
                }
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    selected: Boolean,
    onItemSelected: (Boolean) -> Unit
) {
    NavigationBarItem(
        label = {
            if (selected) {
                Text(screen.title, color = Color.White)
            }
        },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title,
                modifier = if (selected) Modifier.size(32.dp) else Modifier.size(24.dp),
                tint = Color.White
            )
        },
        selected = selected,
        alwaysShowLabel = false,
        onClick = {
              onItemSelected(!selected)
        },
        colors = androidx.compose.material3.NavigationBarItemDefaults
            .colors(
                selectedIconColor = Color.White,
                indicatorColor =  colorResource(id = R.color.BottomNavigationBarIconColor)
            )
    )
}

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.home_icon
        )

    object Notes :
        BottomNavItem(
            "Notes",
            R.drawable.notes_icon
        )

    object Settings :
        BottomNavItem(
            "Settings",
            R.drawable.settings_icon
        )
}

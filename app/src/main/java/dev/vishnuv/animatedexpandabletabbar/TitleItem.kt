package dev.vishnuv.animatedexpandabletabbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class TitleItem(val title: String, val icon: ImageVector, val color: Color)

val items = listOf(
    TitleItem(
        title = "Primary",
        icon = Icons.Outlined.Person,
        color = Color.Blue
    ),
    TitleItem(
        title = "Transactions",
        icon = Icons.Outlined.ShoppingCart,
        color = Color.Green
    ),
    TitleItem(
        title = "Updates",
        icon = Icons.Outlined.Send,
        color = Color(0xFF673AB7)
    ),
    TitleItem(
        title = "Search",
        icon = Icons.Outlined.Search,
        color = Color(0xFFFF5252)
    )
)
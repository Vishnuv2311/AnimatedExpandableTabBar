package dev.vishnuv.animatedexpandabletabbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.vishnuv.animatedexpandabletabbar.ui.theme.AnimatedExpandableTabBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimatedExpandableTabBarTheme {
                ExpandableTab()
            }
        }
    }
}


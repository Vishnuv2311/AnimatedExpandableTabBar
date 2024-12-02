package dev.vishnuv.animatedexpandabletabbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vishnuv.animatedexpandabletabbar.ui.theme.AnimatedExpandableTabBarTheme

@Composable
fun ExpandableTab(modifier: Modifier = Modifier) {


    var selectItem by remember { mutableIntStateOf(0) }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.align(Alignment.Center)
            ) {
                items.forEachIndexed { index, item ->

                    val containerColor by animateColorAsState(
                        label = "Container Color",
                        targetValue = if (index == selectItem) item.color else Color.White,
                        animationSpec = tween(300)
                    )

                    ElevatedButton(
                        onClick = { selectItem = index },
                        shape = CircleShape.copy(CornerSize(10.dp)),
                        colors = ButtonDefaults.elevatedButtonColors(
                            contentColor = if (index == selectItem) Color.White else Color.Black,
                            containerColor = containerColor
                        ),
                        modifier = Modifier.padding(horizontal = 4.dp)
                    ) {
                        Icon(
                            item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(15.dp)
                        )
                        AnimatedVisibility(visible = index == selectItem) {
                            Text(
                                text = item.title,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }

                    }
                }
            }

        }
    }

}


@Preview
@Composable
private fun ExpandableTabPreview() {
    AnimatedExpandableTabBarTheme {
        ExpandableTab()
    }
}
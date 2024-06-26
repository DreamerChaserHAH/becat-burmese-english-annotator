package component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(
    text: String,
    color: Color = Color.Black
) {
    Text(
        modifier = Modifier.padding(4.dp),
        text= text,
        fontSize = TextUnit(32f, TextUnitType.Sp),

    )
}
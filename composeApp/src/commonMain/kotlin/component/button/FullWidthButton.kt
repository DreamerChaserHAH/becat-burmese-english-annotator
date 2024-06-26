package component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FullWidthButton(
    text: String,
    iconResource: DrawableResource? = null,
    onClick: () -> Unit,
    backgroundColor: Color? = null,
    textColor: Color? = null
) {
    Button(
        modifier = Modifier.fillMaxWidth().height(60.dp).padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor ?: Color.Black,
            contentColor = textColor ?: Color.White
        ),
        onClick = onClick,
    ) {
        if (iconResource != null) {
            val iconPainter = painterResource(iconResource)
            Icon(
                modifier = Modifier.padding(end = 8.dp),
                painter = iconPainter,
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier.padding(),
            text = text
        )
    }
}
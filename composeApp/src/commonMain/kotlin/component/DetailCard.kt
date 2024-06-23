package component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun NumericInfoCard(Info: String, Value: String) {
    Card(
        modifier = Modifier.padding(8.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column {
            Text(
                modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                text = Info
            )
            Text(
                modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
                text = Value,
                textAlign = TextAlign.Center,
                fontSize = TextUnit(32f, TextUnitType.Sp)
            )
        }
    }
}
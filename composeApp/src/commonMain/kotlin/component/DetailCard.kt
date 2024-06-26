package component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import component.text.TitleText

@Composable
fun NumericInfoCard(Info: String, value: String) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row (
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ){
            Column(
                modifier = Modifier.fillMaxHeight().weight(7f).padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(8.dp).fillMaxHeight(),
                    textAlign = TextAlign.Start,
                    text = Info
                )
            }
            Column(
                modifier = Modifier.weight(3f).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                TitleText(value)
            }
        }
    }
}

data class UserScore(val userName: String, val score: Int)

@Composable
fun LeaderboardCard(userScores: List<UserScore>) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
    ) {
        Column {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Display Name",
                    modifier = Modifier.padding(8.dp).weight(5f),
                    textAlign = TextAlign.Center
                )
                Text(
                    "Score",
                    modifier = Modifier.padding(8.dp).weight(5f),
                    textAlign = TextAlign.Center
                )
            }
            Column() {
                userScores.forEach { userScore ->
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = userScore.userName,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(1f),
                            text = userScore.score.toString(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    subtitle: String,
    value: String
){
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(100.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp).fillMaxHeight(),
        ){
            Column(
                modifier = Modifier.fillMaxHeight().weight(7f).padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    title,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = TextUnit(16f, TextUnitType.Sp)
                )
                Text(
                    subtitle,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = TextUnit(12f, TextUnitType.Sp)
                )
            }
            Column(
                modifier = Modifier.weight(3f).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                TitleText(value)
            }
        }
    }
}
package screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import component.NumericInfoCard

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(){
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {}){
            Text("Logout")
        }
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("Your Stats")
            FlowRow(
                horizontalArrangement = Arrangement.Center
            ) {
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")
            }
            Text("Global Stats")
            FlowRow(
                horizontalArrangement = Arrangement.Center
            ){
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")
                NumericInfoCard("Total Users", "100")

            }
            Button(onClick = {}){
                Text("Contribute")
            }
        }
    }
}
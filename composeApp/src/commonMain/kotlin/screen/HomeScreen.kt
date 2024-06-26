package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import becat.composeapp.generated.resources.settings
import becat.composeapp.generated.resources.Res
import component.InfoCard
import component.LeaderboardCard
import component.UserScore
import component.button.FullWidthButton
import component.text.TitleText
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController: NavController){

    val settingsImage = painterResource(Res.drawable.settings)
    var expanded by remember { mutableStateOf(false) }
    var dialogExpanded by remember{ mutableStateOf(false) }
    val items = listOf("About", "Logout")
    var selectedIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            TopAppBar(
                modifier = Modifier.fillMaxHeight(),
                title = { Text("BeCat") },
                backgroundColor = Color.Transparent,
                actions = {
                    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
                        IconButton(
                            modifier = Modifier.padding(8.dp),
                            onClick = {
                                expanded = true
                            }
                        ){
                            Icon(
                                painter = settingsImage,
                                contentDescription = "Settings"
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            items.forEachIndexed { index, label ->
                                DropdownMenuItem(onClick = {
                                    selectedIndex = index
                                    expanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                },
            )
        }
        Column(
            modifier = Modifier.weight(9.5f).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            TitleText("Welcome Back, X!")
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                InfoCard("Total Contributions", "Today Contributions : 100", "120")
            }
            FullWidthButton(
                "Contribute",
                onClick = {
                    //navController.navigate(Screen.AnnotateScreen.route)
                    dialogExpanded = true
                })
            Text("Global Stats", modifier = Modifier.padding(8.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                InfoCard("Contributions", "Users: 100", "1000")
                InfoCard("Total Annotations", "Total Source : 1000", "1000")
            }
            Text("Leaderboard", modifier = Modifier.padding(8.dp))
            LeaderboardCard(
                listOf(
                    UserScore("User 1", 100),
                    UserScore("User 2", 200),
                    UserScore("User 3", 300),
                    UserScore("User 4", 400),
                    UserScore("User 5", 500),
                )
            )
        }
    }

    if(dialogExpanded) {
        Dialog(onDismissRequest = { dialogExpanded = false }) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
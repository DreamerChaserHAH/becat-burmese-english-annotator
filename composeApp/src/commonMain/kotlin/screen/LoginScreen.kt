package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import becat.composeapp.generated.resources.Res
import becat.composeapp.generated.resources.github
import becat.composeapp.generated.resources.telegram
import component.button.FullWidthButton
import component.text.TitleText

@Composable
fun LoginScreen(navController: NavController){
    val loginId = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText("BeCat");
        /*
        TextField(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            value = loginId.value,
            label = { Text("Login ID") },
            onValueChange = {
                loginId.value = it
            }
        )
        TextField(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            value = password.value,
            label = { Text("Password") },
            onValueChange = {
                password.value = it
            }
        )*/
        FullWidthButton(
            text = "Login with Telegram",
            iconResource = Res.drawable.telegram,
            backgroundColor = Color(0xFF0088CC),
            textColor = Color.White,
            onClick = {
                /*
                Login(
                    loginId.value,
                    password.value
                )*/
                navController.navigate(Screen.HomeScreen.route)
            }
        )
        FullWidthButton(
            text = "Login with Github",
            iconResource = Res.drawable.github,
            backgroundColor = Color(0xFF24292E),
            textColor = Color.White,
            onClick = {
                /*
                Login(
                    loginId.value,
                    password.value
                )*/
                navController.navigate(Screen.HomeScreen.route)
            }
        )
        Text(
            textAlign = TextAlign.Center,
            text = "version 1.0.0"
        )
    }
}
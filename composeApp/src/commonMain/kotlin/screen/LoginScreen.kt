package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

import logic.Login;

@Composable
fun LoginScreen(){
    val loginId = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().widthIn(0.dp, 400.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(32.dp),
                text="BeCat",
                fontSize = TextUnit(32f, TextUnitType.Sp),
            )
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
            )
            Button(
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                onClick = {
                    Login(
                        loginId.value,
                        password.value
                    )
                }
            ){
                Text("Login")
            }
        }
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            textAlign = TextAlign.Center,
            text = "version 1.0.0"
        )
    }
}
package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import logic.Login;

@Composable
fun LoginScreen(){
    val loginId = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("BeCat")
            TextField(
                modifier = Modifier.padding(8.dp),
                value = loginId.value,
                label = { Text("Login ID") },
                onValueChange = {
                    loginId.value = it
                }
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = password.value,
                label = { Text("Password") },
                onValueChange = {
                    password.value = it
                }
            )
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    Login(
                        loginId.value,
                        password.value
                    )
                }
            ){
                Text("Login")
            }
            Text("version 1.0.0",
                textAlign = TextAlign.Center)
        }
    }
}
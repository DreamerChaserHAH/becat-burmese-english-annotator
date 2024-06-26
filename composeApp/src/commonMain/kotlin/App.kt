import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.AnnotateScreen
import screen.HomeScreen

import screen.LoginScreen
import screen.Screen

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme(
        colors = lightColors(
            primary = Color.Black,
            primaryVariant = Color.Black,
            secondary = Color.Blue,
            secondaryVariant = Color.Blue,
            background = Color.Black,
            surface = MaterialTheme.colors.surface,
            error = MaterialTheme.colors.error,
            onPrimary = Color.White,
            onSecondary = Color.White,
            onBackground = Color.White,
            onSurface = MaterialTheme.colors.onSurface,
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.fillMaxHeight().widthIn(0.dp, 400.dp).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.LoginScreen.route
                ) {
                    composable(Screen.LoginScreen.route) {
                        LoginScreen(navController)
                    }
                    composable(Screen.HomeScreen.route) {
                        HomeScreen(navController)
                    }
                    composable(Screen.AnnotateScreen.route) {
                        AnnotateScreen(navController)
                    }
                }
            }
        }
    }
}
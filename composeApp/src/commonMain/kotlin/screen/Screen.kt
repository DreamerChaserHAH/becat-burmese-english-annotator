package screen

sealed class Screen(val route: String){
    object LoginScreen: Screen("loginScreen")
    object HomeScreen: Screen("homeScreen")
    object AnnotateScreen: Screen("annotateScreen")
}
package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import becat.composeapp.generated.resources.NotoSerifMyanmar
import becat.composeapp.generated.resources.Res
import component.button.FullWidthButton
import org.jetbrains.compose.resources.Font

@Composable
fun AnnotateScreen(navController: NavController){

    val burmeseFont = FontFamily(Font(Res.font.NotoSerifMyanmar))
    val options = listOf("OKAY", "MAYBE", "REJECTED")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            TopAppBar(
                title = { Text("Annotator") },
                navigationIcon = {
                    Button(
                        onClick = { navController.popBackStack() }
                    ){
                        Text("Back")
                    }
                },
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TextField(
                modifier = Modifier.padding(8.dp).fillMaxWidth().weight(1f),
                value = "How are you? I am fine thank you and you?",
                label = {Text("English")},
                onValueChange = {},
                maxLines = Int.MAX_VALUE
            )
            TextField(
                modifier = Modifier.padding(8.dp).fillMaxWidth().weight(1f),
                value = "နေကောင်းလား? ငါအဆင်ပြေပါတယ် ကျေးဇူးတင်ပါတယ် သေချာလား? မင်းကိုချစ်တယ်။ ကောင်းပြီ၊ ဘာဖြစ်ဖြစ်၊",
                label = {Text("မြန်မာစာ")},
                onValueChange = {},
                textStyle = TextStyle(fontFamily = burmeseFont),
                maxLines = Int.MAX_VALUE
            )

        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Row (modifier = Modifier.fillMaxWidth().padding(8.dp)){
                options.forEach { text ->
                    Row(
                        Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { selectedOption = text }
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1.merge(),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
            OutlinedTextField(
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                value = "",
                label = { Text("Feedback") },
                onValueChange = {},
                textStyle = TextStyle(fontFamily = burmeseFont),
                maxLines = Int.MAX_VALUE
            )
            FullWidthButton("Submit", onClick = {})
        }
    }
}
package logic

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import logic.utils.sendPostRequest;

@Serializable
data class LoginData(
    val user_id: String,
    val password: String
);

public fun Login(loginID: String, password: String){
    val json = Json {encodeDefaults= true}
    sendPostRequest(
        "http://localhost:8080/api/user/login",
        LoginData(loginID, password)
    );
}
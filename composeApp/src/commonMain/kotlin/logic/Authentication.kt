package logic

import LOGIN_URL
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
        LOGIN_URL,
        LoginData(loginID, password),
        onSuccess = {response -> {
            //set the token
            //move to home page
        }},
        onForbidden = {
            result -> {
                //show error message
                //login id and password combination is most likely wrong
        }},
        onNotFound = {result -> {
            //show error message
            //user not found
        }}
    );
}

expect fun saveAuthToken(token: String);
expect fun deleteAuthToken()
expect fun getAuthToken()
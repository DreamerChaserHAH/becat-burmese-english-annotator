package logic.utils

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

actual inline fun <reified T>sendPostRequest(
    url: String,
    postData: T,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit) {
    //val jsonData = Json.encodeToString(postData)
    postRequest(url, Json.encodeToString(postData))
}

fun postRequest(url: String, postData: String) {
    js("console.log(postData);fetch(url, {method: 'POST', credentials: 'include', body: postData, headers: {'Content-Type': 'application/json'}}).then(response => response.json()).then(data => console.log(data))")
}

actual inline fun <reified T> sendGetRequest(
    url: String,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
) {
}
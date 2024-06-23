package logic.utils

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

actual inline fun <reified T>sendPostRequest(url: String, postData: T) {
    //val jsonData = Json.encodeToString(postData)
    postRequest(url, Json.encodeToString(postData))
}

fun postRequest(url: String, postData: String) {
    js("fetch(url, {method: 'POST', body: postData, headers: {'Content-Type': 'application/json'}}).then(response => response.json()).then(data => console.log(data))")
}
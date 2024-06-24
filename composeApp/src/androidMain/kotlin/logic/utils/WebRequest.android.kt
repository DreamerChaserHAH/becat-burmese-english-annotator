package logic.utils

import io.ktor.client.*;
import io.ktor.client.features.json.*;
import io.ktor.client.features.json.serializer.*;
import io.ktor.client.request.*;
import io.ktor.http.*;
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
actual inline fun <reified T>sendPostRequest(
    url: String,
    postData: T,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit) {
    GlobalScope.launch {
        val client = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }

        val response: String = client.post(url) {
            contentType(ContentType.Application.Json)
            body = postData!!
        }

        println(response)

        client.close()
    }
}

actual inline fun <reified T> sendGetRequest(
    url: String,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
) {
}
package logic.utils

actual inline fun <reified T>sendPostRequest(
    url: String,
    postData: T,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
) {
}

actual inline fun <reified T> sendGetRequest(
    url: String,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
) {
}
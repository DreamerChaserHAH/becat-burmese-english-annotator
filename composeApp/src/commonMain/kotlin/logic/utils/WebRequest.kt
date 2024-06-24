package logic.utils

expect inline fun <reified T>sendPostRequest(
    url: String,
    postData: T,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
);

expect inline fun <reified T>sendGetRequest(
    url: String,
    onSuccess: (String) -> Unit,
    onForbidden: (String) -> Unit,
    onNotFound: (String) -> Unit
);
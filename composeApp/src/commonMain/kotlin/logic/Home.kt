package logic

import GLOBAL_STATS_URL
import kotlinx.serialization.Serializable
import logic.utils.sendGetRequest

@Serializable
object GlobalStats {
    val total_users: Int = 0;
    val total_text: Int = 0;
    val total_annotated_data: Int = 0;
    val total_unannotated_data: Int = 0
}

fun loadGlobalStats(){
    sendGetRequest<GlobalStats>(GLOBAL_STATS_URL,
        onSuccess = {response -> {
            //parse the response
            //update the UI
            
        }},
        onForbidden = {result -> {
            //show error message
            //user is not authorized
        }},
        onNotFound = {result -> {
            //show error message
            //resource not found
        }})
}
package io.indrian.core.network.responses


import com.google.gson.annotations.SerializedName
import io.indrian.core.models.User

data class GetUsersResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean = false,
    @SerializedName("items")
    val users: List<User> = listOf(),
    @SerializedName("total_count")
    val totalCount: Int = 0
)
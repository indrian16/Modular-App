package io.indrian.core.network.service

import io.indrian.core.models.UserDetail
import io.indrian.core.network.responses.GetUsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubUserService {

    @GET("search/users")
    suspend fun fetchUsers(
        @Query("q") query: String = "indrian",
        @Query("sort") sort: String = "followers"
    ): GetUsersResponse

    @GET("users/{login}")
    suspend fun fetchDetailUser(@Path("login") login: String): UserDetail
}
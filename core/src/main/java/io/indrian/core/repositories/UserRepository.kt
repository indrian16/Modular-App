package io.indrian.core.repositories

import io.indrian.core.network.service.GithubUserService

class UserRepository(
    private val service: GithubUserService
) {
    suspend fun fetchUsers(
        query: String,
        sort: String
    ) = service.fetchUsers(
        query = query,
        sort = sort
    )

    suspend fun fetchDetailUser(login: String) = service.fetchDetailUser(
        login = login
    )
}
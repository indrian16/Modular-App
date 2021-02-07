package io.indrian.core.network

import io.indrian.core.network.service.GithubUserService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubUserServiceTest {

    private lateinit var githubUserService: GithubUserService
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        githubUserService = Retrofit.Builder()
                .baseUrl(mockWebServer.url(""))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubUserService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test fetch users`() = runBlocking {
        enqueueResponse("users.json")

        val response = githubUserService.fetchUsers()
        assertEquals(false, response.incompleteResults)
        assertEquals(86, response.totalCount)

        val users = response.users
        assertEquals("indrian16", users.first().login)

    }

    @Test
    fun `test fetch user detail`() = runBlocking {
        enqueueResponse("user.json")

        val user = githubUserService.fetchDetailUser("indrian")
        assertEquals("indrian16", user.login)
        assertEquals("Tenggarong, Kutai Kartanegara, East Kalimantan", user.location)
    }

    private fun enqueueResponse(filePath: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
        val bufferSource = inputStream?.source()?.buffer()
        val mockResponse = MockResponse()

        mockWebServer.enqueue(
            mockResponse.setBody(
                bufferSource!!.readString(Charsets.UTF_8)
            )
        )
    }
}
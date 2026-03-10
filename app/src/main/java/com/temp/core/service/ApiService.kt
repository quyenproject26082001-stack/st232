package com.temp.core.service
import com.temp.data.model.PartAPI
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("/api/ST197_PrssidePFPMaker")
    suspend fun getAllData(): Response<Map<String, List<PartAPI>>>
}
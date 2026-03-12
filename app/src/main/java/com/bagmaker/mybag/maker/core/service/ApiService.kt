package com.bagmaker.mybag.maker.core.service
import com.bagmaker.mybag.maker.data.model.PartAPI
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("/api/app/ST232_BagMaker")
    suspend fun getAllData(): Response<Map<String, List<PartAPI>>>
}
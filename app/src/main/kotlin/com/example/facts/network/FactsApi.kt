package com.example.facts.network

import io.reactivex.Observable
import com.example.facts.model.CanadaFacts
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface FactsApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("facts")
    fun getFacts(): Observable<CanadaFacts>
}
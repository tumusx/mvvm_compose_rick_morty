package com.github.tumusx.rickmortyapi.data.api

import com.github.tumusx.rickmortyapi.data.model.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("{character}")
    suspend fun getAllCharacter(@Path ("character") character: String) : CharacterDTO

}
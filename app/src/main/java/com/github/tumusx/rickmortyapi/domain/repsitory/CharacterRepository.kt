package com.github.tumusx.rickmortyapi.domain.repsitory

import com.github.tumusx.rickmortyapi.data.model.CharacterDTO
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getAllCharacters(character: String): CharacterDTO

}
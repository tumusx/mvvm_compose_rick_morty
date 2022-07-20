package com.github.tumusx.rickmortyapi.domain.useCase

import com.github.tumusx.rickmortyapi.common.ResultResource
import com.github.tumusx.rickmortyapi.data.model.CharacterDTO
import kotlinx.coroutines.flow.Flow
import okhttp3.Response

interface CharacterUserCase {
    fun configCharacter(character: String) : Flow<ResultResource<CharacterDTO>>
}
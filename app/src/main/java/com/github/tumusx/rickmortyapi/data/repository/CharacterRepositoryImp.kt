package com.github.tumusx.rickmortyapi.data.repository

import com.github.tumusx.rickmortyapi.data.api.CharacterService
import com.github.tumusx.rickmortyapi.data.model.CharacterDTO
import com.github.tumusx.rickmortyapi.domain.repsitory.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(private val characterService: CharacterService) : CharacterRepository {

    override suspend fun getAllCharacters(character: String): CharacterDTO{
        return characterService.getAllCharacter(character)
    }


}
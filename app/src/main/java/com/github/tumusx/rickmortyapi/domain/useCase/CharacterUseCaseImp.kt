package com.github.tumusx.rickmortyapi.domain.useCase

import android.util.Log
import com.github.tumusx.rickmortyapi.common.ResultResource
import com.github.tumusx.rickmortyapi.data.model.CharacterDTO
import com.github.tumusx.rickmortyapi.domain.model.CharacterVO
import com.github.tumusx.rickmortyapi.domain.repsitory.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterUseCaseImp @Inject constructor(private val characterRepository: CharacterRepository) : CharacterUserCase{
    override fun configCharacter(character: String): Flow<ResultResource<CharacterDTO>> = flow{
        val getAllCharacterRepository = characterRepository.getAllCharacters(character)

        try {
            emit(ResultResource.Success(getAllCharacterRepository))
            getAllCharacterRepository.results.forEach {
            CharacterVO(nameCharacter = it.name, imageCharacter = it.image,
                genderCharacter = it.gender, statusCharacter = it.status, originCharacter = it.origin.name, specieCharacter = it.species) }
            Log.d("certo", getAllCharacterRepository.results.toString())

        }catch (exception: Exception){
            emit(ResultResource.Error(exception.message?: "Error. Try latter;"))
            exception.printStackTrace()
            Log.d("errorSh", getAllCharacterRepository.results.toString())
        }
    }

}
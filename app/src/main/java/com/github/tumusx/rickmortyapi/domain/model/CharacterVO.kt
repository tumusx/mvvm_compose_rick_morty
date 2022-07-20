package com.github.tumusx.rickmortyapi.domain.model

import java.io.Serializable

data class CharacterVO(
    val nameCharacter: String,
    val imageCharacter: String,
    val statusCharacter: String,
    val originCharacter: String,
    val specieCharacter: String,
    val genderCharacter: String
): Serializable{

    fun configNameCharacter(): String{
        return try {
            imageCharacter
        }catch (exception: Exception){
            exception.printStackTrace()
            BASE_ERROR_IMG
        }
    }

    companion object{
        const val BASE_ERROR_IMG = "https://d17lbu6bbzbdc8.cloudfront.net/wp-content/uploads/2021/06/15075242/rick-and-morty-season-5-2-1623424070.jpg"
    }
}

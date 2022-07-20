package com.github.tumusx.rickmortyapi.presenter.view

import com.github.tumusx.rickmortyapi.data.model.CharacterDTO

data class CharacterState(
    val isLoading: Boolean = false,
    val messageError: String = "ERROR",
    val character: CharacterDTO? = null
)

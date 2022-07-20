package com.github.tumusx.rickmortyapi.presenter.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.rickmortyapi.common.ResultResource
import com.github.tumusx.rickmortyapi.domain.useCase.CharacterUseCaseImp
import com.github.tumusx.rickmortyapi.presenter.view.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterUserCase: CharacterUseCaseImp) : ViewModel() {
    private val _state = mutableStateOf(CharacterState())
    val characterValue: State<CharacterState> = _state

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            characterUserCase.configCharacter(CHARACTER).onEach {isResultRequest->
                when(isResultRequest){
                    is ResultResource.Success->{
                        Log.d("types", _state.value.toString())
                        _state.value = CharacterState(character = isResultRequest.dataResult)
                    }
                    is ResultResource.Loading->{
                        _state.value = CharacterState(isLoading = true)
                    }
                    is ResultResource.Error->{
                        Log.d("error", _state.value.messageError)
                        _state.value = CharacterState(messageError = isResultRequest.message.toString())
                    }
                }
            }
        }
    }

    companion object{
        const val CHARACTER = "character"
    }


}
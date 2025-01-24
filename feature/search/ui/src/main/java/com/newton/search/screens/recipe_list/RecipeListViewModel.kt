package com.newton.search.screens.recipe_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newton.common.utils.NetworkResult
import com.newton.common.utils.UiText
import com.newton.search.domain.use_cases.GetAllRecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
    private val getAllRecipeUseCase: GetAllRecipeUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecipeListUiState())
    val uiState: StateFlow<RecipeListUiState> get() = _uiState.asStateFlow()

    fun onEvent(event: RecipeListEvent) {
        when(event) {
            is RecipeListEvent.Navigate -> TODO()
            is RecipeListEvent.Search -> {
                search(event.q)
            }
        }
    }

    private fun search(q: String) = getAllRecipeUseCase.invoke(q)
            .onEach { result ->
                when (result) {
                    is NetworkResult.Error -> {
                        _uiState.update { it.copy(error = UiText.RemoteString(result.message.toString())) }
                    }

                    is NetworkResult.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is NetworkResult.Success -> {
                        _uiState.update { it.copy(data = result.data) }
                    }
                }
            }.launchIn(viewModelScope)
}

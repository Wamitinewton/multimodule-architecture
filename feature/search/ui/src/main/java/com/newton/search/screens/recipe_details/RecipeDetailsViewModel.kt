package com.newton.search.screens.recipe_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newton.common.utils.NetworkResult
import com.newton.common.utils.UiText
import com.newton.search.domain.use_cases.GetRecipeDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RecipeDetailsViewModel @Inject constructor(
    private val getRecipeDetails: GetRecipeDetails

) : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeDetailsUiState())
    val uiState: StateFlow<RecipeDetailsUiState> get() = _uiState.asStateFlow()

    fun onEvent(event: RecipeDetailsEvent) {
        when (event) {
            is RecipeDetailsEvent.FetchRecipeDetails -> recipeDetails(event.id)
        }
    }

    private fun recipeDetails(id: String) = getRecipeDetails.invoke(id)
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
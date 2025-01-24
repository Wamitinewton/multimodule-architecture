package com.newton.search.screens.recipe_list

import com.newton.common.utils.UiText
import com.newton.search.domain.model.Recipe

data class RecipeListUiState(
    val isLoading: Boolean = false,
    val error: UiText = UiText.Idle,
    val data: List<Recipe>? = null
)

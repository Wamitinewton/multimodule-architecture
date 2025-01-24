package com.newton.search.screens.recipe_details

import com.newton.common.utils.UiText
import com.newton.search.domain.model.RecipeDetails

data class RecipeDetailsUiState (
    val isLoading: Boolean = false,
    val error: UiText = UiText.Idle,
    val data: RecipeDetails? = null
)
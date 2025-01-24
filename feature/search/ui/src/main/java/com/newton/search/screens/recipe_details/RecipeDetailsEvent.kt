package com.newton.search.screens.recipe_details

sealed interface RecipeDetailsEvent {
    data class FetchRecipeDetails(val id: String) : RecipeDetailsEvent
}
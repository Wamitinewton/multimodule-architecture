package com.newton.search.screens.recipe_list

sealed interface RecipeListNavigation {
    data class RecipeDetails(val id: String) : RecipeListNavigation
}
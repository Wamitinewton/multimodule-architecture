package com.newton.search.screens.recipe_list

sealed interface RecipeListEvent {
    data class Search(val q: String) : RecipeListEvent
    data class Navigate(val navigation: RecipeListNavigation) : RecipeListEvent

}
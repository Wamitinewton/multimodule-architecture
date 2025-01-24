package com.newton.search.domain.repository

import com.newton.common.Resource
import com.newton.search.domain.model.Recipe
import com.newton.search.domain.model.RecipeDetails
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun getRecipes(s: String): Result<List<Recipe>>
    suspend fun getRecipeDetails(id: String): Result<RecipeDetails>
}
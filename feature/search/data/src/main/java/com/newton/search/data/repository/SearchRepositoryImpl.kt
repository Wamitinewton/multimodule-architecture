package com.newton.search.data.repository

import com.newton.search.data.remote.SearchApiService
import com.newton.search.domain.model.Recipe
import com.newton.search.domain.model.RecipeDetails
import com.newton.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApiService: SearchApiService
): SearchRepository {
    override suspend fun getRecipes(s: String): Flow<List<Recipe>> = flow {

    }

    override suspend fun getRecipeDetails(id: String): RecipeDetails {
        TODO("Not yet implemented")
    }
}
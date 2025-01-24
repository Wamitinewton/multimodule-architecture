package com.newton.search.data.repository

import com.newton.search.data.mappers.toDomain
import com.newton.search.data.remote.SearchApiService
import com.newton.search.domain.model.Recipe
import com.newton.search.domain.model.RecipeDetails
import com.newton.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApiService: SearchApiService
) : SearchRepository {
    override suspend fun getRecipes(s: String): Result<List<Recipe>> {
        return try {
            val response = searchApiService.getRecipes(s)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    Result.success(it.toDomain())
                } ?: run {
                    Result.failure(
                        Exception(
                            "Something went wrong"
                        )
                    )
                }
            } else {
                Result.failure(
                    Exception(
                        "Something went wrong"
                    )
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        return try {
            val response = searchApiService.getRecipeDetails(id)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    if (it.isNotEmpty()) {
                        Result.success(it.first().toDomain())
                    } else {
                        Result.failure(Exception("Error occurred"))
                    }
                } ?: run {
                    Result.failure(Exception("Error occurred"))
                }
            } else {
                Result.failure(Exception("Error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
package com.newton.search.domain.use_cases

import com.newton.common.utils.NetworkResult
import com.newton.search.domain.model.Recipe
import com.newton.search.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllRecipeUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    operator fun invoke(q: String) = flow<NetworkResult<List<Recipe>>> {
        emit(NetworkResult.Loading())
        val result = searchRepository.getRecipes(q)
        if (result.isSuccess) {
            emit(NetworkResult.Success(data = result.getOrThrow()))
        } else {
            emit(NetworkResult.Error(message = result.exceptionOrNull()?.localizedMessage ?: ""))
        }
    }.catch {
        emit(NetworkResult.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}
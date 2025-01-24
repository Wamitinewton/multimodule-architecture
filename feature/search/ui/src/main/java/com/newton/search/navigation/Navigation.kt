package com.newton.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.newton.common.navigation.FeatureApi
import com.newton.common.navigation.NavigationRoutes
import com.newton.common.navigation.NavigationSubGraphRoute

interface SearchFeatureApi: FeatureApi


class SearchFeatureApiImpl : SearchFeatureApi {
    override fun registerNavGraph(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
        navGraphBuilder.navigation(
            route = NavigationSubGraphRoute.Search.route,
            startDestination = NavigationRoutes.RecipeList.route
        ) {
            composable(route = NavigationRoutes.RecipeList.route) {

            }

            composable(route = NavigationRoutes.RecipeDetails.route) {

            }
        }
    }

}
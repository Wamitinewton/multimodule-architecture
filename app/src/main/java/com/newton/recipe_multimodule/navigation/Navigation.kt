package com.newton.recipe_multimodule.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.newton.common.navigation.NavigationSubGraphRoute

@Composable
fun RecipeNavigation(modifier: Modifier = Modifier, navigationSubGraphs: NavigationSubGraphs) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationSubGraphRoute.Search.route,
    ){
        navigationSubGraphs.searchFeatureApi.registerNavGraph(
            navHostController = navController,
            navGraphBuilder = this
        )
    }
}
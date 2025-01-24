package com.newton.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    )
}
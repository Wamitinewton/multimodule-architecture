package com.newton.recipe_multimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.newton.recipe_multimodule.navigation.NavigationSubGraphs
import com.newton.recipe_multimodule.navigation.RecipeNavigation
import com.newton.recipe_multimodule.ui.theme.Recipe_multimoduleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationSubGraphs: NavigationSubGraphs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Recipe_multimoduleTheme {
                Surface(modifier = Modifier.safeContentPadding()) {
                    RecipeNavigation(navigationSubGraphs = navigationSubGraphs)
                }
            }
        }
    }
}

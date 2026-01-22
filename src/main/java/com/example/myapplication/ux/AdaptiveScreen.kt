package com.example.myapplication.ux

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.example.myapplication.types.ScreenOrientation

@Composable
fun AdaptiveScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    val orientation =
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE)
            ScreenOrientation.Horizontal
        else
            ScreenOrientation.Vertical


    Screen(
        modifier = modifier,
        content = content
    )
}
package com.teamwable.designsystem.extension.system

import android.app.Activity
import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.teamwable.designsystem.theme.SystemNavigationBar

@Composable
fun SetStatusBarColor(@ColorRes color: Color) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = color.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
}

@Composable
fun SetLightNavigationBar() {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.navigationBarColor = SystemNavigationBar.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = true
        }
    }
}

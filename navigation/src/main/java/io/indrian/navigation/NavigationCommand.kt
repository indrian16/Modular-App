package io.indrian.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class To(val navDirection: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
}
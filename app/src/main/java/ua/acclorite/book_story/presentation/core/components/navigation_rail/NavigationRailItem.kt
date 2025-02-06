/*
 * Book's Story — free and open-source Material You eBook reader.
 * Copyright (C) 2024-2025 Acclorite
 * SPDX-License-Identifier: GPL-3.0-only
 */

package ua.acclorite.book_story.presentation.core.components.navigation_rail

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ua.acclorite.book_story.domain.navigator.NavigatorItem
import ua.acclorite.book_story.presentation.core.components.common.StyledText
import ua.acclorite.book_story.presentation.core.components.common.Tooltip

@Composable
fun NavigationRailItem(
    modifier: Modifier = Modifier,
    item: NavigatorItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationRailItem(
        label = {
            Tooltip(
                text = stringResource(id = item.tooltip),
                padding = 48.dp
            ) {
                StyledText(
                    text = stringResource(id = item.title),
                    maxLines = 1
                )
            }
        },
        selected = isSelected,
        onClick = { onClick() },
        icon = {
            Tooltip(
                text = stringResource(id = item.tooltip),
                padding = 16.dp
            ) {
                Crossfade(
                    targetState = isSelected,
                    animationSpec = tween(150),
                    label = ""
                ) {
                    if (it) {
                        Icon(
                            painter = painterResource(id = item.selectedIcon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.unselectedIcon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        },
        modifier = modifier
    )
}
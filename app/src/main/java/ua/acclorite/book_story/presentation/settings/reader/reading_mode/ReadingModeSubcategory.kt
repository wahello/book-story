@file:Suppress("FunctionName")

package ua.acclorite.book_story.presentation.settings.reader.reading_mode

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import ua.acclorite.book_story.R
import ua.acclorite.book_story.presentation.settings.components.SettingsSubcategory
import ua.acclorite.book_story.presentation.settings.reader.reading_mode.components.HorizontalGestureOption
import ua.acclorite.book_story.presentation.settings.reader.reading_mode.components.HorizontalGestureScrollOption

fun LazyListScope.ReadingModeSubcategory(
    titleColor: @Composable () -> Color = { MaterialTheme.colorScheme.primary },
    title: @Composable () -> String = { stringResource(id = R.string.reading_mode_reader_settings) },
    showTitle: Boolean = true,
    showDivider: Boolean = true,
    topPadding: Dp,
    bottomPadding: Dp
) {
    SettingsSubcategory(
        titleColor = titleColor,
        title = title,
        showTitle = showTitle,
        showDivider = showDivider,
        topPadding = topPadding,
        bottomPadding = bottomPadding
    ) {
        item {
            HorizontalGestureOption()
        }

        item {
            HorizontalGestureScrollOption()
        }
    }
}
package ua.acclorite.book_story.presentation.settings.reader.progress.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ua.acclorite.book_story.R
import ua.acclorite.book_story.domain.ui.ButtonItem
import ua.acclorite.book_story.domain.util.HorizontalAlignment
import ua.acclorite.book_story.presentation.core.components.settings.SegmentedButtonWithTitle
import ua.acclorite.book_story.ui.main.MainEvent
import ua.acclorite.book_story.ui.main.MainModel
import ua.acclorite.book_story.ui.theme.ExpandingTransition

@Composable
fun ProgressBarAlignmentOption() {
    val mainModel = hiltViewModel<MainModel>()
    val state = mainModel.state.collectAsStateWithLifecycle()

    ExpandingTransition(visible = state.value.progressBar) {
        SegmentedButtonWithTitle(
            title = stringResource(id = R.string.progress_bar_alignment_option),
            buttons = HorizontalAlignment.entries.map {
                ButtonItem(
                    id = it.toString(),
                    title = when (it) {
                        HorizontalAlignment.START -> stringResource(id = R.string.alignment_start)
                        HorizontalAlignment.CENTER -> stringResource(id = R.string.alignment_center)
                        HorizontalAlignment.END -> stringResource(id = R.string.alignment_end)
                    },
                    textStyle = MaterialTheme.typography.labelLarge,
                    selected = it == state.value.progressBarAlignment
                )
            },
            onClick = {
                mainModel.onEvent(
                    MainEvent.OnChangeProgressBarAlignment(
                        it.id
                    )
                )
            }
        )
    }
}
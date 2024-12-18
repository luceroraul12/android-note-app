package com.luceroraul.noteapp.ui.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luceroraul.noteapp.R
import com.luceroraul.noteapp.ui.CustomScaffold
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Preview
@Composable
private fun PreviewNoteListView() {
    ListNoteView()
}

@Preview
@Composable
private fun PreviewItemListNote() {
    ItemListNote()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListNoteView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    CustomScaffold(title = "Notas", modifier = modifier.padding(horizontal = 16.dp)) {
        LazyColumn(modifier = modifier) {
            items(10) {
                val delete = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Red,
                    onSwipe = { Toast.makeText(context, "Click en item $it", Toast.LENGTH_SHORT).show() }
                )
                val edit = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Create),
                    background = Color.Green,
                    onSwipe = { Toast.makeText(context, "Click en item $it", Toast.LENGTH_SHORT).show() }
                )
                SwipeableActionsBox(
                    startActions = listOf(delete),
                    endActions = listOf(edit),
                    swipeThreshold = 100.dp
                ) {
                    ItemListNote(modifier = modifier.fillParentMaxHeight(1/5f))
                }
            }
        }
    }
}

@Composable
fun ItemListNote(modifier: Modifier = Modifier) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)) {
            Text(
                "Titulo",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                "Categoria",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                stringResource(R.string.lorem),
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify
            )
        }
    }
}
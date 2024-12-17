package com.luceroraul.noteapp.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewNewNoteView() {
    NewNoteView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteView(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Edición de nota", color = MaterialTheme.colorScheme.primary)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it).padding(horizontal = 8.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = modifier.weight(1f)) {
                val mod = modifier.padding(6.dp).fillMaxWidth()
                OutlinedTextField(modifier= mod, value = "", onValueChange = {}, placeholder = {Text("Título")})
                OutlinedTextField(modifier= mod, value = "", onValueChange = {}, placeholder = {Text("Categoría")})
                OutlinedTextField(modifier= mod.weight(1f), value = "", onValueChange = {}, placeholder = {Text("Descripción")})
            }
            Row(
                modifier = Modifier
            ) {
                val mod = modifier.padding(8.dp).weight(1f)
                OutlinedButton(onClick = {}, modifier = mod) { Text("Cancelar") }
                Button(onClick = {}, modifier = mod) { Text("Guardar") }
            }
        }
    }
}
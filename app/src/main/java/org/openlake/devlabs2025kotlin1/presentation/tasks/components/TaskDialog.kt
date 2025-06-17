package org.openlake.devlabs2025kotlin1.presentation.tasks.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskDialog(
    showTaskDialog: Boolean,
    initialTitle: String = "",
    initialDescription: String = "",
    initialPriority: Int = 3,
    initialStatus: String = "To Do",
    onDismiss: () -> Unit,
    onSave: (String, String, Int, String) -> Unit,
    onDelete: (() -> Unit)? = null
) {
    var title by remember { mutableStateOf(initialTitle) }
    var description by remember { mutableStateOf(initialDescription) }
    var priority by remember { mutableIntStateOf(initialPriority) }
    var status by remember { mutableStateOf(initialStatus) }
    var showDeleteConfirm by remember { mutableStateOf(false) }
    var showPriorityDialog by remember { mutableStateOf(false) }

    if (showTaskDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("New Task") },
            text = {
                Column {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") },
                        placeholder = { Text("Enter task title") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        placeholder = { Text("Enter task description") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = { showPriorityDialog = true }) {
                            Text("Priority: $priority")
                        }
                        TextButton(onClick = {
                            status = if (status == "To Do") {
                                    "In Progress"
                                } else if (status == "In Progress") {
                                    "Done"
                                } else "To Do"
                        }) {
                            Text("Status: $status")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onSave(title, description, priority, status)
                    onDismiss()
                }) {
                    Text("Create Task")
                }
            },
            dismissButton = {
                Row {
                    if (onDelete != null) {
                        TextButton(onClick = { showDeleteConfirm = true }) {
                            Text("Delete")
                        }
                    }
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                }
            }
        )
    }

    if (showDeleteConfirm) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirm = false },
            title = { Text("Delete Task") },
            text = { Text("Are you sure you want to delete this task?") },
            confirmButton = {
                TextButton(onClick = {
                    onDelete?.invoke()
                    showDeleteConfirm = false
                    onDismiss()
                }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteConfirm = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showPriorityDialog) {
        AlertDialog(
            onDismissRequest = { showPriorityDialog = false },
            title = { Text("Select Priority") },
            text = {
                Column {
                    (1..5).forEach { prio ->
                        Row(
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            RadioButton(
                                selected = priority == prio,
                                onClick = { priority = prio }
                            )
                            Text("Priority $prio")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showPriorityDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPriorityDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDialogPreview() {
    TaskDialog(
        showTaskDialog = true,
        initialTitle = "Sample Task",
        initialDescription = "This is a sample description.",
        onDismiss = {},
        onSave = { _, _, _, _ -> }
    )
}
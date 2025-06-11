package tf.iitb.myapplication.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NavigationDrawer(
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit
) {
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(24.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Text("Username", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("user@example.com", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        NavigationDrawerItem(
            label = { Text("Tasks") },
            selected = false,
            onClick = { onNavigate("tasks") },
            icon = { Icon(Icons.Default.Check, contentDescription = null) }
        )
        NavigationDrawerItem(
            label = { Text("Notes") },
            selected = true,
            onClick = { onNavigate("notes") },
            icon = { Icon(Icons.Default.List, contentDescription = null) }
        )
        NavigationDrawerItem(
            label = { Text("Settings") },
            selected = false,
            onClick = { onNavigate("settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) }
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigationDrawerItem(
            label = { Text("Logout") },
            selected = false,
            onClick = { onLogout() },
            icon = { Icon(Icons.Default.ExitToApp, contentDescription = null) }
        )
    }
}

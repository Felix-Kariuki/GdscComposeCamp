package com.flexcode.gdsckabarak.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.flexcode.gdsckabarak.ui.theme.darkBlue

@Composable
fun BasicButton(
    text: String,
    modifier: Modifier,
    action: () -> Unit
) {
    Button(
        onClick = action,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = darkBlue,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

package com.flexcode.gdsckabarak.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.flexcode.gdsckabarak.R
import com.flexcode.gdsckabarak.common.BasicButton
import com.flexcode.gdsckabarak.common.BasicText
import com.flexcode.gdsckabarak.common.EmailField
import com.flexcode.gdsckabarak.common.PasswordField
import com.flexcode.gdsckabarak.common.utils.basicButton
import com.flexcode.gdsckabarak.common.utils.fieldModifier
import com.flexcode.gdsckabarak.ui.theme.darkBlue

@Composable
fun LoginScreen(
    navigateToHome : (String) -> Unit,
    modifier: Modifier  = Modifier,
    viewModel: LoginViewModel,
) {
    val uiState  by viewModel.uiState

    val gradient = Brush.verticalGradient(
        listOf(darkBlue, Color.White),
        startY = 600.0f,
        endY = 1700.0f
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = gradient)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = modifier.height(20.dp))
            BasicText(
                text = "GDSC",
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(R.drawable.gdg),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp).offset(y = (-24).dp)
            )

            BasicText(
                text = "Kabarak",
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = modifier.offset(y = (-48).dp)
            )

            Spacer(modifier = modifier.height( 20.dp))

            Column(modifier = modifier
                .background(Color.White, shape = RoundedCornerShape(30.dp))
                .fillMaxHeight()
            ) {
                BasicText(text = "Your Name")
                EmailField(
                    value = uiState.name,
                    icon = Icons.Default.Email,
                    onNewValue = viewModel::onNameChange,
                    Modifier.fieldModifier()
                )

                BasicText(text = "Password")
                PasswordField(
                    value = uiState.password,
                    onNewValue = viewModel::onPasswordChange,
                    Modifier.fieldModifier()
                )
                BasicButton(
                    text = "Continue",
                    modifier = modifier
                        .basicButton()
                        .height(50.dp)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    viewModel.navigateToHome{navigateToHome(uiState.name) }
                }

            }

        }
    }
}
package dev.fast25.tictactoepro.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fast25.tictactoepro.R
import dev.fast25.tictactoepro.view.CreateRoomBottomSheetContainer
import dev.fast25.tictactoepro.view.JoinRoomBottomSheetContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen() {
    var gameId by remember {
        mutableStateOf("")
    }

    val sheetState = rememberModalBottomSheetState()
    var isCreateSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    var isJoinSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF63C367),
                        Color(0xFF4c9dae),
                    ),
                    start = Offset(x = 2f, y = 4f),
                    end = Offset(x = 1f, y = 5f),
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "Logo",
            )
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    modifier = Modifier
                        .fillMaxWidth(.5f),
                    onClick = { isCreateSheetOpen = true }
                ) {
                    Text(text = "Create Game", color = Color.White)
                }
                Spacer(modifier = Modifier.width(15.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = { isJoinSheetOpen = true }
                ) {
                    Text(text = "Join Game", color = Color.White)
                }
            }

        }
    }

    if (isCreateSheetOpen) {

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isCreateSheetOpen = false
            }
        ) {
            CreateRoomBottomSheetContainer()

        }
    }

    if (isJoinSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isJoinSheetOpen = false
            }
        ) {
            JoinRoomBottomSheetContainer()

        }
    }

}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
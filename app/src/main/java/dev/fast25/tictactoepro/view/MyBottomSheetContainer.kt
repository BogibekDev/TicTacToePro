package dev.fast25.tictactoepro.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.fast25.tictactoepro.utils.Constants


@Composable
fun CreateRoomBottomSheetContainer() {
    Scaffold(
        topBar = {
            Column {
                Text(
                    modifier = Modifier
                        .height(75.dp)
                        .padding(start = 29.dp, top = 26.dp),
                    text = "Here is your room ID ",
                    fontSize = 23.sp,
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                text = "${Constants.gameId}",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

@Composable
fun JoinRoomBottomSheetContainer() {
    var gameId by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .height(75.dp)
                    .padding(start = 29.dp, top = 26.dp),
                text = "Enter room ID: ",
                fontSize = 23.sp
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = gameId,
                        onValueChange = { id ->
                            if (id.length <= Constants.gameIdLength) gameId = id
                        },
                        modifier = Modifier.fillMaxWidth(.5f),
                        textStyle = TextStyle(
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (gameId.length == 5) joinGame(gameId.toInt())
                            }
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            if (gameId.length == 5) joinGame(gameId.toInt())
                        },
                        modifier = Modifier.fillMaxWidth(.5f)
                    ) {
                        Text(text = "Join Game")
                    }
                }

            }

        }
    }
}

fun joinGame(id: Int) {
    if (id == Constants.gameId) {
        //navigate GameScreen
    }
}

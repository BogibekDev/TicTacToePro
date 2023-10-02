package dev.fast25.tictactoepro.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
                text = "2344432",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

@Composable
fun JoinRoomBottomSheetContainer() {
    Scaffold(topBar = {
        Column {
            Text(
                text = "Enter room ID: ", modifier = Modifier
                    .height(75.dp)
                    .padding(start = 29.dp, top = 26.dp), fontSize = 23.sp
            )
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text(
                text = "1524515",
                modifier = Modifier
                    .padding(start = 29.dp, top = 20.dp, bottom = 10.dp)
                    .height(40.dp), fontSize = 20.sp
            )

        }
    }
}
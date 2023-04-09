package com.trafficapp.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.trafficapp.R
import com.trafficapp.models.TrafficData

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DisplayTrafficData(listData: List<TrafficData>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Title
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            style = TextStyle(
                Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ),
            fontWeight = FontWeight.Normal
        )

        // List Items from Data
        LazyColumn {
            items(listData) { trafficItems ->
                //Traffic image
                GlideImage(
                    model = trafficItems.trafficCamera.url,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                )
                //Traffic location text
                Text(
                    trafficItems.cameraLocation, modifier = Modifier
                        .padding(bottom = 15.dp)
                        .fillParentMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )
                //Divider
                Divider(modifier = Modifier.height(2.dp))
            }
        }
    }
}

@Composable
fun EmptyState(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.something_went_wrong),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 24.0F, TextUnitType.Sp)
            )
        )

        Button(
            onClick = { onRetry.invoke() }
        ) {
            Text(text = stringResource(id = R.string.retry), color = Color.Black)
        }
    }
}
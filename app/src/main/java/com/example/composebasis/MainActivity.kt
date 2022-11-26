package com.example.composebasis

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasis.ui.theme.ComposeBasisTheme
import com.example.composebasis.ui.theme.LatoFamily
import com.example.composebasis.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasisTheme {
                FeedItem()
            }
        }
    }
}

@Composable
fun FeedItem() {
    Column {
        Box {
            Image(
                painterResource(R.drawable.thumbnail),
                "Thumbnail"
            )
            Text(
                text = "26:15",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp, 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_launcher_background),
                "Channel Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Jetpack Compose - Fundamentos")
                Row {
                    Text(
                        text = "Channel Name",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = " - 247 views",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = " - 2 weeks ago",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Composable
fun CustomText(@StringRes textResId: Int) {
    Text(
        text = stringResource(id = textResId),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { Log.d("Welcome", "Clicked") },
        color = Teal200,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body1
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasisTheme {
        FeedItem()
    }
}
package com.example.designpatterns.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designpatterns.android.ui.theme.DesignPatternsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<MainViewModel>()
        enableEdgeToEdge()
        setContent {
            DesignPatternsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding),
                        points = viewModel.pointsState,
                        calculatePoints = viewModel::calculatePointsAccumulated
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    points: Double,
    calculatePoints: (PointStrategy, Double) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = "Point Simulation",
            style = MaterialTheme.typography.titleLarge
        )


        Text(text = "Do you want to know how many points you'll gain with every purchase?")
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { calculatePoints(GoldPoint(), 100.0) }) {
                Text(text = "Gold")
            }

            Button(onClick = { calculatePoints(PlatinumPoint(), 100.0)  }) {
                Text(text = "Platinum")
            }

            Button(onClick = { calculatePoints(SignaturePoint(), 100.0) }) {
                Text(text = "Signature")
            }
        }

        Text(text = "Points you would gain: $points")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContent() {
    DesignPatternsTheme {
        Content(
            points = 100.0,
            calculatePoints = { _, _ -> }
        )
    }
}
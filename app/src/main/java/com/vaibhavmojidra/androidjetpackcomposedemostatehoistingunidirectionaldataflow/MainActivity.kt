package com.vaibhavmojidra.androidjetpackcomposedemostatehoistingunidirectionaldataflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.androidjetpackcomposedemostatehoistingunidirectionaldataflow.ui.theme.AndroidJetpackComposeDemoStateHoistingUnidirectionalDataflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeDemoStateHoistingUnidirectionalDataflowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var count by remember{ mutableStateOf(0) }
                    stateHoistingDemo(count){
                        count=it+1
                    }
                }
            }
        }
    }
}

@Composable
fun stateHoistingDemo(currentCount:Int,updateCount:(Int)->Unit){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            updateCount(currentCount)
        }) {
         Text(text = "Count is $currentCount", fontSize = 26.sp)
        }
    }
}
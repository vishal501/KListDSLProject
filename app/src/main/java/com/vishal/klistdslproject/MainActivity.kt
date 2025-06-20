package com.vishal.klistdslproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vishal.klistdslproject.klist.KListDemo
import com.vishal.klistdslproject.ui.theme.KListDSLProjectTheme
import com.vishal.klistdslproject.ui.theme.KListDSLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KListDSLTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    KListDemo()
                }
            }
        }
    }
}
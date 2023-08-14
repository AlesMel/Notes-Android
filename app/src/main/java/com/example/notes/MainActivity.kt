package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.ui.components.BottomNavigationBar
import com.example.notes.ui.components.CreateWidget
import com.example.notes.ui.components.NavigationButtons
import com.example.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                MainContent()
            }
        }
    }
}

@Composable
private fun MainContent() {
    // A surface container using the 'background' color from the theme

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            NavigationButtons("Home")
            Row {
                CreateWidget (
                    title = "Plan forThe Day",
                    modifier = Modifier
                        .weight(1f / 2f)
                        .padding(12.dp, 12.dp, 6.dp, 12.dp),
                    backgroundColor = colorResource(id = R.color.widget_color_1)
                ) { }
                Column(
                    modifier = Modifier
                        .weight(1f / 2f)
                ) {
                    CreateWidget(
                        title = "Add Notes",
                        modifier = Modifier
                            .padding(6.dp, 12.dp, 12.dp, 6.dp)
                            .height(156.dp),
                        backgroundColor = colorResource(id = R.color.widget_color_2)
                    ) { }
                    CreateWidget(
                        title = "Add Notes",
                        modifier = Modifier
                            .padding(6.dp, 6.dp, 12.dp, 12.dp)
                            .height(156.dp),
                        backgroundColor = colorResource(id = R.color.widget_color_4)
                    ) { }
                }
            }
            CreateWidget (
                title = "Add New Note",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .padding(12.dp, 12.dp, 12.dp, 12.dp),
                backgroundColor = colorResource(id = R.color.widget_color_3)
            ) {}
            CreateWidget (
                title = "Widget",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .padding(12.dp, 12.dp, 12.dp, 12.dp),
                backgroundColor = colorResource(id = R.color.widget_color_4)
            ) {}
            CreateWidget (
                title = "Widget",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .padding(12.dp, 12.dp, 12.dp, 12.dp),
                backgroundColor = colorResource(id = R.color.accent)
            ) {}
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigationBar()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    NotesTheme {
        Column {
            MainContent()
        }
    }
}
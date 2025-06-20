package com.vishal.klistdslproject.klist
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast

@Composable
fun KListDemo() {
    val topGainers = listOf("Bitcoin", "Ethereum", "Solana")
    val trending = listOf("Shiba Inu", "Dogecoin", "Pepe")
    val context = LocalContext.current

    KList.create<String>()
        .padding(16.dp)
        .header("Top Gainers")
        .items(topGainers) {
            KListItem(it)
        }
        .header("Trending Now")
        .items(trending) {
            KListItem(it)
        }
        .clickable { coin ->
            Toast.makeText(context, "Clicked on $coin", Toast.LENGTH_SHORT).show()
        }
        .withDividers()
        .render()
}
package com.vishal.klistdslproject.klist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class KList<T> private constructor() {

    private var padding: Dp = 0.dp
    private val headers = mutableListOf<String>()
    private val sections = mutableListOf<Pair<List<T>, @Composable (T) -> Unit>>()
    private var itemClickable: ((T) -> Unit)? = null
    private var showDividers: Boolean = false

    companion object {
        fun <T> create(): KList<T> = KList()
    }

    fun padding(dp: Dp): KList<T> {
        this.padding = dp
        return this
    }

    fun header(title: String): KList<T> {
        this.headers.add(title)
        return this
    }

    fun items(items: List<T>, itemContent: @Composable (T) -> Unit): KList<T> {
        this.sections.add(Pair(items, itemContent))
        return this
    }

    fun clickable(onClick: (T) -> Unit): KList<T> {
        this.itemClickable = onClick
        return this
    }

    fun withDividers(): KList<T> {
        this.showDividers = true
        return this
    }

    @Composable
    fun render() {
        LazyColumn(modifier = Modifier
            .padding(padding)
            .animateContentSize()
        ) {
            headers.forEach { title ->
                item {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 8.dp)
                            .background(Color(0xFFF1F1F1))
                            .fillMaxWidth()
                            .padding(12.dp)
                    )
                }
            }

            sections.forEach { (sectionItems, content) ->
                items(sectionItems) { item ->
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .then(
                            if (itemClickable != null)
                                Modifier.clickable { itemClickable?.invoke(item) }
                            else Modifier
                        )
                    ) {
                        content(item)
                        if (showDividers) {
                            Spacer(modifier = Modifier.height(1.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .padding(horizontal = 16.dp)
                                .background(Color.LightGray))
                        }
                    }
                }
            }
        }
    }
}



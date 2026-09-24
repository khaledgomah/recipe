package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.CustomChip
import com.example.myapplication.data.categories


@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        var selectedCategory:Int by rememberSaveable { mutableIntStateOf(categories.first().id) }
        CustomSearchBar()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding =PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) {category ->
                CustomChip(selectedCategoryID = selectedCategory, onClick = {
                    selectedCategory = it
                }, category = category)
            }
        }
        }
    }




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar() {
    var text by rememberSaveable() { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = text,
                onQueryChange = { text = it },
                onSearch = {
                    expanded = false
                },
                expanded = false,
                onExpandedChange = { expanded = it },
                placeholder = { Text("Search") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search icon")
                },
                trailingIcon = {
                    if (expanded) {
                        IconButton(onClick = {
                                expanded = false
                        }) {
                            Icon(Icons.Default.Close, contentDescription = "Close icon")
                        }
                    }
                }
            )
        },
        expanded = false,

        onExpandedChange = { expanded = it },
        modifier = Modifier
    ) {
    }
}
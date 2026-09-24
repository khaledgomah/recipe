package com.example.myapplication.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList

class AppBackStack<T: Any>(startKey: T) {
    private var topLevelStacks : LinkedHashMap<T, SnapshotStateList<T>> = linkedMapOf(
        startKey to mutableStateListOf(startKey)
    )

    var topLevelKey by mutableStateOf(startKey)
        private set

    // Expose the back stack so it can be rendered by the NavDisplay
    val backStack = mutableStateListOf(startKey)

    private fun updateBackStack() {
        backStack.apply {
            clear()
            addAll(topLevelStacks.flatMap { it.value })
        }
    }

    fun addTopLevel(key: T) {
        // If the top level doesn't exist, add it
        if (topLevelStacks[key] == null) {
            topLevelStacks[key] = mutableStateListOf(key)
        } else {
            // Otherwise just move it to the end of the stacks
            topLevelStacks.remove(key)?.let {
                topLevelStacks[key] = it
            }
        }
        topLevelKey = key
        updateBackStack()
    }

    fun add(key: T) {
        topLevelStacks[topLevelKey]?.add(key)
        updateBackStack()
    }

    fun removeLast(): Boolean {
        val stack = topLevelStacks[topLevelKey]
        if (stack == null || stack.size <= 1) {
            // If it's the last item in a top-level stack, see if we can switch back to previous tab
            if (topLevelStacks.size > 1) {
                topLevelStacks.remove(topLevelKey)
                topLevelKey = topLevelStacks.keys.last()
                updateBackStack()
                return true
            }
            return false // Let the system handle back press (exit app)
        }
        stack.removeLastOrNull()
        updateBackStack()
        return true
    }
    
    fun replaceAll(key: T) {
        topLevelStacks.clear()
        topLevelStacks[key] = mutableStateListOf(key)
        topLevelKey = key
        updateBackStack()
    }
}

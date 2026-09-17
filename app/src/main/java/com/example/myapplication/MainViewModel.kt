package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import kotlin.time.Duration.Companion.milliseconds

class MainViewModel: ViewModel() {
    private var countdownJob: Job? = null
    private val _currentNum = MutableStateFlow(10)
    val currentNum = _currentNum.asStateFlow<Int>()

    fun toggle() {
        if (countdownJob?.isActive == true) {
            countdownJob?.cancel()
            countdownJob = null
        } else {
            countdownJob = viewModelScope.launch {
                while (true){
                    val value = _currentNum .value -1
                    _currentNum.emit(value)
                    delay(100.milliseconds)
                }
            }
        }
    }
}
package com.example.designpatterns.android

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var pointUseCase: PointUseCase = PointUseCase()
    var pointsState by mutableDoubleStateOf(0.0)

    fun calculatePointsAccumulated(strategy: PointStrategy, amount: Double) {
        val points = pointUseCase.execute(strategy, amount)
        pointsState = points
    }
}
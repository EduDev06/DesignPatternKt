package com.example.designpatterns.android

interface PointStrategy {
    fun calculatePoint(amount: Double): Double
}

class GoldPoint: PointStrategy {
    override fun calculatePoint(amount: Double): Double {
        return amount * 0.30
    }
}

class PlatinumPoint: PointStrategy {
    override fun calculatePoint(amount: Double): Double {
        return amount * 0.32
    }
}

class SignaturePoint: PointStrategy {
    override fun calculatePoint(amount: Double): Double {
        return amount * 0.35
    }
}

class PointUseCase {
    fun execute(strategy: PointStrategy, amount: Double): Double {
        return strategy.calculatePoint(amount)
    }
}
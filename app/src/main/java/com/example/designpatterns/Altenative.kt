package com.example.designpatterns

fun main() {
    val warrior = MyWarrior()
    val myCurrentLife = 10.0
    val result = warrior.calculateAttack(
        attack = SwordAttack(),
        currentLife = myCurrentLife
    )
    println("My enemy now has: $result of life")
}

interface AttackStrategy {
    fun calculateAttack(currentLife: Double): Double
}

class SwordAttack: AttackStrategy {
    override fun calculateAttack(currentLife: Double): Double = currentLife - 1.9
}

class MagicAttack: AttackStrategy {
    override fun calculateAttack(currentLife: Double): Double = currentLife - 2.6
}

class MyWarrior {
    fun calculateAttack(attack: AttackStrategy, currentLife: Double): Double {
        return attack.calculateAttack(currentLife)
    }
}

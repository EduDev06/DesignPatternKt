package com.example.designpatterns

enum class ATTACKS {
    SWORD,
    MAGIC,
    SPECIAL
}

class Warrior {
    fun calculateAttack(attack: ATTACKS, currentLife: Double): Double {
        return when (attack) {
            ATTACKS.SWORD -> calculateSwordAttack(currentLife)
            ATTACKS.MAGIC -> calculateMagicAttack(currentLife)
            ATTACKS.SPECIAL -> TODO()
        }
    }
}

fun main() {
    val warrior = Warrior()
    val myAttack = ATTACKS.MAGIC
    val myCurrentLife = 10.0
    val result = warrior.calculateAttack(myAttack, myCurrentLife)
    println("My enemy now has: $result of life")
}


private fun calculateSwordAttack(currentLife: Double) = currentLife - 1.9
private fun calculateMagicAttack(currentLife: Double) = currentLife - 2.6
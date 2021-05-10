package com.example.cs481projectapp

import org.junit.Test

class CalculatorTest {

    @Test
    fun cogSuitTest01() {
        val c = CalculatorActivity()
        val cog = "Bossbot"
        val nd = 5500
        val ob = 0
        val ans = c.findCogSuit(cog, nd, ob)
        println("suit: $cog; obtained: $ob out of $nd")
        println("RESULTS: $ans")
    }

    @Test
    fun cogSuitTest02() {
        val c = CalculatorActivity()
        val cog = "Bossbot"
        val nd = 23300
        val ob = 300
        val ans = c.findCogSuit(cog, nd, ob)
        println("suit: $cog; obtained: $ob out of $nd")
        println("RESULTS: $ans")
    }

    @Test
    fun cogSuitTest03() {
        val c = CalculatorActivity()
        val cog = "Bossbot"
        val nd = 23300
        val ob = 12000
        val ans = c.findCogSuit(cog, nd, ob)
        println("suit: $cog; obtained: $ob out of $nd")
        println("RESULTS: $ans")
    }

    @Test
    fun cogSuitTest04() {
        val c = CalculatorActivity()
        val cog = "Sellbot"
        val nd = 7600
        val ob = 420
        val ans = c.findCogSuit(cog, nd, ob)
        println("suit: $cog; obtained: $ob out of $nd")
        println("RESULTS: $ans")
    }
}
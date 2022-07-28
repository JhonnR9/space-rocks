package me.jhonn.game

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import me.jhonn.game.main.SpaceGame

fun main() {
    val config = Lwjgl3ApplicationConfiguration().apply {
        setForegroundFPS(60)
        setWindowedMode(800,600)
        setTitle("Space Rocks")
        this.setWindowIcon("spaceship.png")
    }
    Lwjgl3Application(SpaceGame(), config)
}





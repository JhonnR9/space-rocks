package me.jhonn.game.main

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputProcessor
import me.jhonn.game.screens.BaseScreen

abstract class BaseGame : Game() {


    companion object {
        lateinit var game: BaseGame
        var inputMultiplexer: InputMultiplexer = InputMultiplexer()

        fun setActiveScreen(s: BaseScreen) {
            if (Companion::game.isInitialized) {
                game.screen = s
                Gdx.input.inputProcessor = inputMultiplexer
            } else {
                throw UninitializedPropertyAccessException("please initialize the game in GameClass before setter active screen")
            }
        }

    }
}
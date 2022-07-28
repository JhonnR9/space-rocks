package me.jhonn.game.main

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputProcessor
import me.jhonn.game.main.BaseGame
import me.jhonn.game.screens.LevelScreen
import me.jhonn.game.screens.MenuScreen

class SpaceGame : BaseGame() {

    override fun create() {
        game = this
        setActiveScreen(MenuScreen())

    }





}
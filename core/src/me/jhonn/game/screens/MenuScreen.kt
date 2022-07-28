package me.jhonn.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Input.Keys
import me.jhonn.game.main.BaseGame
import me.jhonn.game.entities.BaseActor


class MenuScreen() : BaseScreen() {
    init {
        BaseActor(0f,0f,mainStage).apply {
            loadTexture("menuScreen.tga")
            //centerAtPosition(300f,400f)

        }
    }

    override fun update(deltaTime: Float) {

    }

    override fun keyDown(keycode: Int): Boolean {
        if (keycode == Keys.S){
            BaseGame.setActiveScreen(LevelScreen())
        }
        return super.keyDown(keycode)
    }



}
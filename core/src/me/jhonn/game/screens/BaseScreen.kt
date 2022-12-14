package me.jhonn.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import me.jhonn.game.main.BaseGame

abstract class BaseScreen : Screen, InputProcessor {
    val mainStage: Stage = Stage()
    val uiStage: Stage = Stage()

    init {
      addInputs()
    }

    abstract fun update(deltaTime: Float)
    private fun addInputs(){
        BaseGame.inputMultiplexer.apply {
            addProcessor(this@BaseScreen)
            addProcessor(uiStage)
            addProcessor(mainStage)
        }
    }

    override fun show() {
       addInputs()
    }

    override fun hide() {
        BaseGame.inputMultiplexer.apply {
            removeProcessor(this@BaseScreen)
            removeProcessor(uiStage)
            removeProcessor(mainStage)
        }
    }

    override fun render(delta: Float) {

        uiStage.act(delta)
        mainStage.act(delta)
        update(delta)
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        mainStage.draw()
        uiStage.draw()
    }

    override fun resize(width: Int, height: Int) {

    }

    override fun pause() {}

    override fun resume() {

    }


    override fun dispose() {}


    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(c: Char): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }
}
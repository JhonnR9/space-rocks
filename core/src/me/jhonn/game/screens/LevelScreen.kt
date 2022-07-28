package me.jhonn.game.screens

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import me.jhonn.game.entities.*
import me.jhonn.game.entities.BaseActor.Companion.count
import me.jhonn.game.entities.BaseActor.Companion.createWorldBounds
import me.jhonn.game.main.BaseGame


class LevelScreen : BaseScreen() {
    private var spaceship: Spaceship
    private var gameOver = false
    val ufo: Ufo

    init {
        BaseActor(0f, 0f, mainStage).apply {
            loadTexture("space.png")
            setSize(800f, 600f)
            createWorldBounds(this)
        }

        spaceship = Spaceship(400f, 300f, mainStage)

        Rock(600f, 500f, mainStage)
   /*     Rock(600f, 300f, mainStage)
        Rock(600f, 100f, mainStage)
        Rock(400f, 100f, mainStage)
        Rock(200f, 100f, mainStage)
        Rock(200f, 300f, mainStage)
        Rock(200f, 500f, mainStage)
        Rock(400f, 500f, mainStage)*/

        ufo = Ufo(500f, 500f, mainStage)

    }

    override fun keyDown(keycode: Int): Boolean {

        if (keycode == Keys.X) {
            spaceship.warp()
        }
        if (keycode == Keys.SPACE) {
            spaceship.shoot()
        }



        super.keyDown(keycode)
        return false
    }

    override fun update(deltaTime: Float) {
        spaceship.preventOverlap(ufo)
        for (rockActor in BaseActor.getList(mainStage, "Rock")) {
            if (rockActor.overlaps(spaceship)) {
                if (spaceship.shieldPower <= 0) {
                    Explosion(mainStage).apply {
                        centerAtActor(spaceship)
                        spaceship.remove()
                        spaceship.setPosition(-1000f, -1000f)
                    }
                    BaseActor(0f, 0f, uiStage).apply {
                        loadTexture("message-lose.png")
                        centerAtPosition(400f, 300f)
                        setOpacity(0f)
                        addAction(Actions.fadeIn(1f))
                        gameOver = true
                    }
                } else {
                    spaceship.shieldPower -= 34
                    Explosion(mainStage).apply {
                        centerAtActor(rockActor)
                        rockActor.remove()
                    }
                }

            }
            for (laserActor in BaseActor.getList(mainStage, "Laser")) {

                if (laserActor.overlaps(ufo)){
                    println(ufo.life)
                    ufo.life -= 20
                }
                if(ufo.life  <= 0){
                    Explosion(mainStage).apply {
                        centerAtActor(ufo)
                        setSize(ufo.width,ufo.height)
                    }
                }


                if (laserActor.overlaps(rockActor)) {
                    Explosion(mainStage).apply {
                        centerAtActor(rockActor)
                        laserActor.remove()
                        rockActor.remove()
                    }
                }
            }
        }
        if (!gameOver && count(mainStage, "Rock") == 0) {
            BaseActor(0f, 0f, uiStage).apply {
                loadTexture("message-win.png")
                centerAtPosition(400f, 300f)
                setOpacity(0f)
                addAction(Actions.fadeIn(1f))
                gameOver = true
            }
        }


    }


}
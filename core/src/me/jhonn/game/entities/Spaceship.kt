package me.jhonn.game.entities

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage

class Spaceship(x: Float, y: Float, stage: Stage) : BaseActor(x, y, stage) {
    private val thrusters = Thrusters(0f, 0f, stage)
    val shield: Shield
    var shieldPower = 50f

    init {
        loadTexture("spaceship.png")
        boundaryPolygon = createBoundaryPolygon(8)

        acceleration = 150f
        maxSpeed = 200f
        deceleration = 100f

        thrusters.setPosition(-thrusters.width, height / 2 - thrusters.height / 2)
        addActor(thrusters)

        shield = Shield(0f, 0f, stage)
        shield.centerAtPosition(width / 2, height / 2)
        addActor(shield)

    }


    override fun act(delta: Float) {
        super.act(delta)
        move(delta)
        shield.setOpacity(shieldPower / 100f)
        if (shieldPower < 0) {
            shield.isVisible = false
        }
        boundToWorld()
        applyPhysics(delta)

    }

    fun warp() {
        if (stage == null) return

        val warp1 = Warp(0f, 0f, stage)
        warp1.centerAtActor(this)
        setPosition(MathUtils.random(800f), MathUtils.random(600f))

        val warp2 = Warp(0f, 0f, stage)
        warp1.centerAtActor(this)


    }

    fun shoot() {
        if (stage == null) return
        Laser(0f,0f,stage).apply {
            centerAtActor(this@Spaceship)
            rotation = this@Spaceship.rotation
            motionAngle = this@Spaceship.rotation
        }
    }


    private fun move(delta: Float) {
        val degreesPerSecond = 120f  // rotation speed
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rotateBy(degreesPerSecond * delta)

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rotateBy(-degreesPerSecond * delta)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            accelerateAtAngle(rotation)
            thrusters.isVisible = true
        } else {
            thrusters.isVisible = false
        }

    }

}
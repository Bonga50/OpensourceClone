package za.ac.iie.opsc7311.birdiegame

import android.content.Context
import android.graphics.*
import android.view.View

class BirdieGameView(context: Context?) : View(context) {

    // bitmaps
    private var bird : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.wingsup)
    private var birdDown : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.wingsdown)
    private var greengrassbackground : Bitmap = BitmapFactory.decodeResource(resources,
        R.drawable.villagescreensize)
    private var pugicorn : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.puggicorn)
    private var cuppicake : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.cuppicake)
    private var lifealive : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.smallalive)
    private var lifedead : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.smalldead)

    // paint
    private var scoreCounter = Paint()
    private var levelCounter = Paint()

    // bird position and speed
    private var birdX = 10f
    private var birdY = 50f
    private var birdSpeed = 10
    private var touchFlag = false

    // screen size
    private var canvasHeight = 0
    private var canvasWidth = 0

    init {
        scoreCounter.color = Color.BLACK
        scoreCounter.textSize = 30f
        scoreCounter.typeface = Typeface.DEFAULT_BOLD
        scoreCounter.isAntiAlias = true

        levelCounter.color = Color.BLUE
        levelCounter.textSize = 30f
        levelCounter.typeface = Typeface.DEFAULT_BOLD
        levelCounter.textAlign = Paint.Align.CENTER
        levelCounter.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // get screen size
        if (canvas != null) {
            canvasHeight = canvas.height
            canvasWidth = canvas.width
        }

        // take careful note of the order here
        canvas?.drawBitmap(greengrassbackground, 0f, 0f, null)

        // calculate the minimum Y value for the bird - one size below the top of the screen
        var minBirdY = bird.height

        // calculate the maximum Y value for the bird - one size above the bottom of the screen
        var maxBirdY = canvasHeight - bird.height

        // calculate the position of the bird
        birdY += birdSpeed

        // draw the bird
        canvas?.drawBitmap(bird, 0.0f, 0.0f, null)

        // draw the score and level
        canvas?.drawText("Score: 0", 20f, 60f, scoreCounter)
        canvas?.drawText("Level 1", canvasWidth.toFloat()/2, 60f, levelCounter)

        // display the icons for the lives
        canvas?.drawBitmap(lifealive, canvasWidth.toFloat() - 300, 30f, null)
        canvas?.drawBitmap(lifealive, canvasWidth.toFloat() - 200, 30f, null)
        canvas?.drawBitmap(lifealive, canvasWidth.toFloat() - 100, 30f, null)
    }
}
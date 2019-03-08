package tests

import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.stage.Stage
import javafx.animation.AnimationTimer
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import javafx.scene.text.Font


fun main() {
    JFXPanel()
    Platform.runLater { launch () }
}

fun launch() {
    val stage = Stage()
    stage.width = 400.0
    stage.height = 200.0
    stage.isResizable = false
    stage.show()

    val group = Group()
    val scene = Scene(group)
    stage.scene = scene

    val canvas = Canvas()
    canvas.width = 400.0
    canvas.height = 200.0
    group.children.add(canvas)

    val gc = canvas.graphicsContext2D
    gc.font = Font("Comic Sans MS", 24.0)
    val upLine = DragLine()
    val sideLine = DragLine()


    canvas.onMouseMoved = EventHandler<MouseEvent> { event ->
        sideLine.dx = event.sceneX
        upLine.dy = event.sceneY
    }
    val at = object : AnimationTimer() {
        private var last: Long = 0

        override fun handle(now: Long) {

            if(now - last >= 16_000_000) {
                gc.clearRect(0.0,0.0,400.0,200.0);
                gc.strokeLine(200.0,100.0,200.0,upLine.dy)
                gc.strokeLine(200.0,100.0,sideLine.dx,100.0)
                last = now
            }
        }
    }
    println("a")
    at.start()
}

class DragLine {
     var x: Double = 200.0
     var y: Double = 100.0
     var dx: Double = 0.0
     var dy: Double = 0.0
}

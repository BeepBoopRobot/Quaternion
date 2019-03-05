import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Group
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.scene.input.KeyCode



fun main() {
    JFXPanel()
    Platform.runLater { launch() }
}

fun launch () {
    val stage = Stage()
    stage.width = 500.0
    stage.height = 500.0
    stage.isResizable = false
    stage.initStyle(StageStyle.UNDECORATED)
    stage.show()

    val group = Group()
    val scene = Scene(group)
    stage.scene = scene

    scene.setOnKeyPressed { ke ->
        if (ke.code == KeyCode.ESCAPE) {
            System.exit(0)
        }
    }


}


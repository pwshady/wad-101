package visual

import javafx.application.Platform
import javafx.scene.Parent
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import tornadofx.*
import java.awt.Color
import java.awt.Color.*
import java.time.LocalDate
import kotlin.concurrent.thread

class WADViev : View()
{
    override val root: Parent = borderpane() {

        top = menubar {
            menu("File")
            menu("Edit")
        }

        left = vbox {
            label("hello")
            label("hi")
            datepicker(){
                value = LocalDate.now()
            }
        }

        center = tabpane {

            tab("S1") {
                vbox {
                    button("B1")
                    rectangle {
                        arcHeight = 20.0
                        arcWidth = 20.0
                        width = 200.0
                        height = 200.0

                    }
                }

                println("s1")
            }

            tab("S2") {

                vbox {
                    button("B2")
                }
            }





        }

        right = vbox {
            button("Press Me"){
                textFill = javafx.scene.paint.Color.RED
                action { this.textFill = javafx.scene.paint.Color.GREEN }

            }
        }

        bottom = hbox {
            progressbar {
                thread {
                    for (i in 1..100)
                    {
                        Platform.runLater()
                        {
                            progress = i.toDouble() / 100
                        }
                        Thread.sleep(100)
                    }
                }
            }
        }
    }

}
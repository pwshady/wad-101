package visual

import javafx.application.Platform
import javafx.scene.Parent
import javafx.scene.control.TabPane
import settings.BaseSettings
import tornadofx.*
import java.time.LocalDate
import kotlin.concurrent.thread


class Screen1 : Fragment("Sc1"){
    override val root = vbox {
        button("B52")
    }

}

class WADViev : View()
{
    override val root: Parent = borderpane() {
        val bs = BaseSettings()
        val resust = bs.loadSet()
        if (!resust){
            println("t")
        }
        top = vbox{
            this += WADVievTopMenu::class
        }

        left = vbox {

        }

        center = tabpane {

            for (i in 1..1) {
                tab("S1") {
                    vbox {
                        button("B1"){
                            action {
                                //tabPane.selectionModel.select(3)
                                println(selectionModel.selectedIndex)
                            }

                        }
                        rectangle {
                            arcHeight = 20.0
                            arcWidth = 20.0
                            width = 200.0
                            height = 200.0

                        }
                    }
                }
            }

            tab("S2") {

                vbox {
                    button("B2")
                }
                val numbers = (1..10).toList()
                datagrid(numbers) {
                    cellHeight = 75.0
                    cellWidth = 75.0
                    multiSelect = true
                    cellCache {
                        stackpane {
                            circle (radius = 25) {
                                fill =javafx.scene.paint.Color.GREEN
                            }
                            label {
                                it.toString() }
                        }
                    }
                }
            }
            tab("+"){
                this += WADVievAddProject::class
            }
            selectionModel.selectedItemProperty().onChange {
                var i = selectionModel.selectedIndex
                if (i == 2){
                    tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
                }else{
                    tabClosingPolicy = TabPane.TabClosingPolicy.SELECTED_TAB
                }
                println(i)
            }



        }

        right = vbox {
            button("Press Me"){
                action {  }
                //textFill = javafx.scene.paint.Color.RED
                //action { this.textFill = javafx.scene.paint.Color.GREEN }

            }
            button("t1").action {
                find<WADModalVievDBConnect>().openWindow(owner = null)
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
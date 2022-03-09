package visual

import javafx.scene.Parent
import tornadofx.Fragment
import tornadofx.item
import tornadofx.menu
import tornadofx.menubar

class WADVievTopMenu : Fragment("WADTopMenu") {
    override val root: Parent = menubar {

        menu("File") {
            item("New project")
            item("Open project")
            menu ("Stop"){  }
            menu ("Stop and close"){  }
            item("Exit")
        }

        menu("Viev"){
            menu("Language"){
                item("England")
            }
        }

        menu ("Help"){
            item("About")
        }

    }

}
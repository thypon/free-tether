package it.gtd.freetether

import org.scaloid.common._
import com.stericson.RootTools.RootTools

class RootChecker extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      SButton("Check Root", RootTools.isAccessGiven)
    }.padding(20 dip)
  }
}

package org.scaloid.hello

import org.scaloid.common._
import android.graphics.Color
import com.stericson.RootTools.RootTools
import com.stericson.RootTools.execution.CommandCapture
import android.R

class HelloScaloid extends SActivity {

  onCreate {
    contentView = new SVerticalLayout {
      SButton("Unlock Tether", Tether.unlock)
      SButton("Lock Tether", Tether.lock)
    } padding 20.dip
  }

}
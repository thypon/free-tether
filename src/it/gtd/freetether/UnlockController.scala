package it.gtd.freetether

import android.content.{Intent, Context, BroadcastReceiver}
import org.scaloid.common.{Logger, TagUtil}

class UnlockController extends BroadcastReceiver with Logger with TagUtil {
  def onReceive(context: Context, intent: Intent) = new WifiAP(context).state match {
    case Enabled =>
      info(s"$Enabled received")
      Tether.unlock()
    case Disabled => Tether.lock()
      info(s"$Disabled received")
    case x =>
      info(s"$x received")
  }
}
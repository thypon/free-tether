package it.gtd.freetether

import com.stericson.RootTools.RootTools
import com.stericson.RootTools.execution.CommandCapture

object Tether extends PIMP {
  def unlock(): Boolean = {
    lazy val shell = RootTools.getShell(true)

    if (RootTools.isAccessGiven) {
      try {
        shell.add("iptables -t nat -A natctrl_nat_POSTROUTING -s 192.168.0.0/16 -o rmnet0 -j MASQUERADE")
        shell.wait()
      } catch {
        case e: Exception => return false
      }
    }
    true
  }

  def lock(): Boolean = {
    lazy val shell = RootTools.getShell(true)

    if (RootTools.isAccessGiven) {
      try {
        shell.add("iptables -t nat -D natctrl_nat_POSTROUTING 1")
        shell.wait()
      } catch {
        case e: Exception => return false
      }
    }
    true
  }
}

class PIMP {
  private var id = 0
  implicit protected def stringToCommandCapture(string: String): CommandCapture = {
    id += 1
    new CommandCapture(id, string)
  }
}
package it.gtd.freetether

import android.content.Context
import android.net.wifi.WifiManager
import org.scaloid.common.{TagUtil, Logger}

sealed trait State
case object Unknown extends State
case object Disabling extends State
case object Disabled extends State
case object Enabling extends State
case object Enabled extends State
case object Failed extends State

class WifiAP(ctx: Context) extends TagUtil with Logger {
  lazy val wifiManager = ctx.getSystemService(Context.WIFI_SERVICE).asInstanceOf[WifiManager]

  def state() = wifiManager.getClass().getMethod("getWifiApState")
      .invoke(wifiManager).asInstanceOf[Int] match {
          case 0 => Disabling
          case 10 => Disabling
          case 1 => Disabled
          case 11 => Disabled
          case 2 => Enabling
          case 12 => Enabling
          case 3 => Enabled
          case 13 => Enabled
          case 4 => Failed
          case 14 => Failed
          case x =>
            warn(s"Unknown value: $x")
            Unknown
      }
}

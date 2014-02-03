package it.gtd.freetether.wifi;

import eu.chainfire.libsuperuser.Shell;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class Tether {
    @Getter(lazy = true) private static final Tether instance = new Tether();

    public boolean unlock() {
        if (Shell.SU.available()) {
            Shell.SU.run("iptables -t nat -A natctrl_nat_POSTROUTING -s 192.168.0.0/16 -o rmnet0 -j MASQUERADE");
            return true;
        } else {
            return false;
        }
    }

    public boolean lock() {
        if (Shell.SU.available()) {
            Shell.SU.run("iptables -t nat -D natctrl_nat_POSTROUTING 1");
            return true;
        } else {
            return false;
        }
    }
}

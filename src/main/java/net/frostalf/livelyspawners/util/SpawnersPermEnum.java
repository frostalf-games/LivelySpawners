/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners.util;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.entity.Player;

/**
 *
 * @author Frostalf
 */
public enum SpawnersPermEnum {
    ADMIN("livelyspawners.admin", "livelyspawners.*"),
    NOEXPLOSION("livelyspawners.noexplosion", "livelyspawners.*");

    String perm;
    ArrayList<String> hierarchy = new ArrayList<String>();

    SpawnersPermEnum(String perm, String... hierarchy) {
        this.perm = perm;
        this.hierarchy.addAll(Arrays.asList(hierarchy));

    }

    public boolean hasPerm(Player player) {
        if (!(player.hasPermission(this.perm))) {
            for (String s : this.hierarchy) {
                if (player.hasPermission(s)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}

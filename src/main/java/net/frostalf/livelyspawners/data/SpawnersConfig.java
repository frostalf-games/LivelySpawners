/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners.data;

import net.frostalf.livelyspawners.LivelySpawners;

/**
 *
 * @author Frostalf
 */
public class SpawnersConfig {

    private LivelySpawners plugin = LivelySpawners.getInstance();
    private static SpawnersConfig instance;

    private SpawnersConfig() {
        instance = this;
    }

    public static SpawnersConfig getConfigInstance() {
        if (instance == null) {
            instance = new SpawnersConfig();
        }
        return instance;
    }
}

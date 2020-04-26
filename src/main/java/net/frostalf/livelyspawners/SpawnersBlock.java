/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 *
 * @author Frostalf
 */
public class SpawnersBlock {

    private Block block;
    private int spawnerLives = 0;
    private Location spawnerLocation;

    public SpawnersBlock(Block block) {
        this.block = block;
        spawnerLocation = this.block.getLocation();
    }

    public int getSpawnerLives() {
        return this.spawnerLives;
    }

    public Block getSpawner() {
        return this.block;
    }

    public Location getSpawnerLocation() {
        return spawnerLocation;
    }

    public Material getSpawnerMaterial() {
        return this.block.getType();
    }

}

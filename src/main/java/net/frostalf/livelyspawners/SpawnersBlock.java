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
    private int spawnerLives;
    private Location spawnerLocation;

    public SpawnersBlock(Location location, int lives) {
        this.block = location.getBlock();
        this.spawnerLives = lives;
        spawnerLocation = this.block.getLocation();
    }

    public int getSpawnerLives() {
        return this.spawnerLives;
    }

    public void reduceLives() {
        this.spawnerLives -= 1;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.frostalf.livelyspawners.listeners;

import net.frostalf.livelyspawners.LivelySpawners;
import net.frostalf.livelyspawners.SpawnersBlock;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.MetadataValueAdapter;

/**
 *
 * @author Frostalf
 */
public class SpawnersBlockListener implements Listener {

    private LivelySpawners plugin = LivelySpawners.getInstance();
    private SpawnersBlock spawnBlock;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        World world = block.getWorld();
        Player player = event.getPlayer();
        //SpawnersBlock spawnBlock = new SpawnersBlock(block, spawnerLives);
        if (world.toString().equalsIgnoreCase(plugin.getConfig().getString("world"))) {
            Location blockLocation = block.getLocation();
            int spawnerLives = plugin.getConfig().getInt("lives") - 1;
            if (plugin.getSpawnersMap().containsKey(blockLocation)) {
                SpawnersBlock spawnBlock = plugin.getSpawnersMap().get(blockLocation);
                if (spawnBlock.getSpawnerLives() != 0) {
                    spawnBlock.reduceLives();
                } else {
                    block.breakNaturally();
                    ItemStack is = new ItemStack(Material.getMaterial(plugin.getConfig().getString("item_drop")), plugin.getConfig().getInt("item_amount"));
                    plugin.getServer().getWorld(block.getWorld().toString()).dropItemNaturally(blockLocation, is);
                }
            } else {
                spawnBlock = new SpawnersBlock(block, spawnerLives);
                plugin.getSpawnersMap().put(blockLocation, spawnBlock);
            }
        }
        plugin.getServer().getWorld("").createExplosion(block.getLocation(), Float.valueOf(plugin.getConfig().getString("explosivepower")), true, false);
        event.setCancelled(true);
    }
}

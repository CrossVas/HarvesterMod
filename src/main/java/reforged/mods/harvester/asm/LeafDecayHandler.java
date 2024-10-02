package reforged.mods.harvester.asm;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class LeafDecayHandler {

    static Random rng = new Random();
    static int randomizationTime = 7;
    static int baseDecayTime = 4;

    public static void handleLeafDecay(World world, int x, int y, int z) {
        int id = world.getBlockId(x, y, z);
        Block block = Block.blocksList[id];
        if (block != null) {
            if (!block.translateBlockName().toLowerCase().contains("ore berries")) {
                world.scheduleBlockUpdate(x, y, z, id, baseDecayTime + rng.nextInt(randomizationTime));
            }
        }
    }
}

package myid.chiqors.cheesemod.generation;

import cpw.mods.fml.common.IWorldGenerator;
import myid.chiqors.cheesemod.ModCore;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class CheeseGeneration implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        // -1=nether, 0=overworld, 1=theend
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
            case 1:
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateNether(World world, Random rand, int x, int z) {
        generateOre(ModCore.blockCheese, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.end_stone);
    }

    public void generateOverworld(World world, Random rand, int x, int z) {
        generateOre(ModCore.blockCheese, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.stone);
    }

    public void generateEnd(World world, Random rand, int x, int z) {
        generateOre(ModCore.blockCheese, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.netherrack);
    }

    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
        int vienSize = minVienSize+random.nextInt(maxVienSize-minVienSize); // Generate random vien size
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, vienSize, generateIn);
        for(int i = 0; i < chance; i++) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, xRand, yRand, zRand);
        }
    }
}

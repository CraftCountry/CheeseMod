package myid.chiqors.cheesemod.block;

import myid.chiqors.cheesemod.ModCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCheese extends Block {
    public BlockCheese(Material material) {
        super(material);
        //this.setBlockUnbreakable();
        //this.setResistance(2000.0F); 2000F for unbreakable, 15F Mildly exploded
        this.setHardness(0.5F); // 2.0F Hard Block, 1.0F Easier Block. (Depends on material). Cloth = Hand Tool
        //this.setHarvestLevel("pickaxe", 4); //MCDiamondLevel 3. Level 4 not exist (mod level custom)
        this.setLightLevel(0.2F); //Light Zone (1 max)
        this.setLightOpacity(5); //1 = 15 light level to pass through. 16 = no light level to go through. 16 - X = X2
        this.setStepSound(this.soundTypeSnow); //Step sound
    }

    @Override
    public boolean isOpaqueCube() {
        // If your block texture is transparent, return false
        return true;
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune) {
        return ModCore.itemCheese;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 2 + rand.nextInt(5); // 2 + random 0-5 extra
    }
}

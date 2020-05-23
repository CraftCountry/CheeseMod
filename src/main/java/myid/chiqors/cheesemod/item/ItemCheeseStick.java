package myid.chiqors.cheesemod.item;

import net.minecraft.item.Item;

public class ItemCheeseStick extends Item {
    public ItemCheeseStick() {
        //this.setContainerItem(ModCore.itemCheese); // give each item cheese return a reward crafted item
        //this.setMaxStackSize(8); // StackMaxSize
        //this.setMaxDamage(1000); // gives max damage to the item depends on the machine that taking damage to this item
        //this.setPotionEffect(PotionHelper.blazePowderEffect); // set a potion effect
        this.setFull3D(); // gives a 3d look (sword)
    }
}

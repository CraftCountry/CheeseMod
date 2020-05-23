package myid.chiqors.cheesemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import myid.chiqors.cheesemod.block.*;
import myid.chiqors.cheesemod.generation.CheeseGeneration;
import myid.chiqors.cheesemod.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ModHelper.ModInfo.modid, name = ModHelper.ModInfo.name, version = ModHelper.ModInfo.version, acceptedMinecraftVersions = ModHelper.ModInfo.mcversion)
public class ModCore {

    public static Item itemTablet;

    public static Item itemCheese;
    public static Item itemCookedCheese;

    public static Item itemCheeseStick;

    public static Item itemCheesePickaxe;
    public static Item itemCheeseAxe;
    public static Item itemCheeseShovel;
    public static Item itemCheeseHoe;
    public static Item itemCheeseSword;

    public static Item itemCheeseHelmet;
    public static Item itemCheeseChestplate;
    public static Item itemCheeseLeggings;
    public static Item itemCheeseBoots;

    public static Block blockDriedDirt;
    public static Block blockCheese;

    public static final Item.ToolMaterial cheeseToolMaterial = EnumHelper.addToolMaterial("cheeseToolMaterial", 4, 2000, 15.0F, 5.0F, 30);
    public static final ItemArmor.ArmorMaterial cheeseArmorMaterial = EnumHelper.addArmorMaterial("cheeseArmorMaterial", 5000, new int[]{20,30,25,15}, 30); // DefaultDurablitySize 2,7,5,3

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registering
        // Config handling
        // Items
        itemTablet = new ItemTablet().setUnlocalizedName("ItemTablet").setTextureName(ModHelper.ModInfo.modid+":tablet").setCreativeTab(tabCheeseMod);
        // Foods X * 0.5 = 2.5 hearts/hunger (Beef 0.8F saturation)
        itemCheese = new ItemFood(8, 0.5F, false).setUnlocalizedName("ItemCheese").setTextureName(ModHelper.ModInfo.modid+":cheese").setCreativeTab(tabCheeseMod);
        itemCookedCheese = new ItemFood(16, 1.0F, true).setUnlocalizedName("ItemCookedCheese").setTextureName(ModHelper.ModInfo.modid+":cooked_cheese").setCreativeTab(tabCheeseMod);
        // Materials or Crafting Items
        itemCheeseStick = new ItemCheeseStick().setUnlocalizedName("ItemCheeseStick").setTextureName(ModHelper.ModInfo.modid+":stick_cheese").setCreativeTab(tabCheeseMod);
        // Tools
        itemCheesePickaxe = new ItemCheesePickaxe(cheeseToolMaterial).setUnlocalizedName("ItemCheesePickaxe").setTextureName(ModHelper.ModInfo.modid+":cheese_pickaxe").setCreativeTab(tabCheeseMod);
        itemCheeseAxe = new ItemCheeseAxe(cheeseToolMaterial).setUnlocalizedName("ItemCheeseAxe").setTextureName(ModHelper.ModInfo.modid+":cheese_axe").setCreativeTab(tabCheeseMod);
        itemCheeseShovel = new ItemCheeseShovel(cheeseToolMaterial).setUnlocalizedName("ItemCheeseShovel").setTextureName(ModHelper.ModInfo.modid+":cheese_shovel").setCreativeTab(tabCheeseMod);
        itemCheeseHoe = new ItemCheeseHoe(cheeseToolMaterial).setUnlocalizedName("ItemCheeseHoe").setTextureName(ModHelper.ModInfo.modid+":cheese_hoe").setCreativeTab(tabCheeseMod);
        itemCheeseSword = new ItemCheeseSword(cheeseToolMaterial).setUnlocalizedName("ItemCheeseSword").setTextureName(ModHelper.ModInfo.modid+":cheese_sword").setCreativeTab(tabCheeseMod);
        // Armors
        itemCheeseHelmet = new ItemCheeseArmor(cheeseArmorMaterial, 0, 0).setUnlocalizedName("ItemCheeseHelmet").setTextureName(ModHelper.ModInfo.modid+":cheese_helmet").setCreativeTab(tabCheeseMod); // ArmorTypeIndex (0=helmet..3=boots)
        itemCheeseChestplate = new ItemCheeseArmor(cheeseArmorMaterial, 0, 1).setUnlocalizedName("ItemCheeseChestplate").setTextureName(ModHelper.ModInfo.modid+":cheese_chestplate").setCreativeTab(tabCheeseMod);
        itemCheeseLeggings = new ItemCheeseArmor(cheeseArmorMaterial, 0, 2).setUnlocalizedName("ItemCheeseLeggings").setTextureName(ModHelper.ModInfo.modid+":cheese_leggings").setCreativeTab(tabCheeseMod);
        itemCheeseBoots = new ItemCheeseArmor(cheeseArmorMaterial, 0, 3).setUnlocalizedName("ItemCheeseBoots").setTextureName(ModHelper.ModInfo.modid+":cheese_boots").setCreativeTab(tabCheeseMod);
        // Blocks
        blockDriedDirt = new BlockDriedDirt(Material.sand).setBlockName("DriedDirt").setBlockTextureName(ModHelper.ModInfo.modid+":drieddirt").setCreativeTab(tabCheeseMod);
        blockCheese = new BlockCheese(Material.rock).setBlockName("BlockCheese").setBlockTextureName(ModHelper.ModInfo.modid+":block_cheese").setCreativeTab(tabCheeseMod);

        // Items
        GameRegistry.registerItem(itemTablet, itemTablet.getUnlocalizedName().substring(5));
        // Foods
        GameRegistry.registerItem(itemCheese, itemCheese.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCookedCheese, itemCookedCheese.getUnlocalizedName().substring(5));
        // Materials or Crafting Items
        GameRegistry.registerItem(itemCheeseStick, itemCheeseStick.getUnlocalizedName().substring(5));
        // Tools
        GameRegistry.registerItem(itemCheesePickaxe, itemCheesePickaxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseAxe, itemCheeseAxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseShovel, itemCheeseShovel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseHoe, itemCheeseHoe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseSword, itemCheeseSword.getUnlocalizedName().substring(5));
        // Armors
        GameRegistry.registerItem(itemCheeseHelmet, itemCheeseHelmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseChestplate, itemCheeseChestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseLeggings, itemCheeseLeggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheeseBoots, itemCheeseBoots.getUnlocalizedName().substring(5));
        // Blocks
        GameRegistry.registerBlock(blockDriedDirt, blockDriedDirt.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockCheese, blockCheese.getUnlocalizedName().substring(5));

        // Smelting
        GameRegistry.addSmelting(itemCheese, new ItemStack(itemCookedCheese), 5.0F);
        GameRegistry.addSmelting(itemCheeseStick, new ItemStack(Blocks.bedrock), 5.0F);

        // Generation
        GameRegistry.registerWorldGenerator(new CheeseGeneration(), 0);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Proxy, Entity, TileEntity, Recipe, GUI, and Registering
        // Items
        GameRegistry.addRecipe(new ItemStack(itemTablet, 2), new Object[]{"WWW"," W "," W ", 'W', Blocks.planks}); // Object{First Row(var,var,var),...} or Object{Row(var),Row(var),Row(var),...} flexible recipe
        // Materials or Crafting Items
        GameRegistry.addRecipe(new ItemStack(itemCheese), new Object[]{"CC","CC",'C',itemCheeseStick});
        // Tools
        GameRegistry.addRecipe(new ItemStack(itemCheesePickaxe), new Object[]{"CCC"," S "," S ",'C',itemCheese,'S',Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemCheeseAxe), new Object[]{"CC","CS","S",'C',itemCheese,'S',Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemCheeseShovel), new Object[]{"C","S","S",'C',itemCheese,'S',Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemCheeseHoe), new Object[]{"CC","S","S",'C',itemCheese,'S',Items.stick});
        // Armors
        GameRegistry.addRecipe(new ItemStack(itemCheeseHelmet), new Object[]{"CCC","C C",'C',itemCookedCheese});
        GameRegistry.addRecipe(new ItemStack(itemCheeseChestplate), new Object[]{"C C","CCC","CCC",'C',itemCookedCheese});
        GameRegistry.addRecipe(new ItemStack(itemCheeseLeggings), new Object[]{"CCC","C C","C C",'C',itemCookedCheese});
        GameRegistry.addRecipe(new ItemStack(itemCheeseBoots), new Object[]{"C C","C C",'C',itemCookedCheese});
        // Blocks
        GameRegistry.addRecipe(new ItemStack(blockDriedDirt, 10), new Object[]{"CRC","RRR","CRC",'C',Blocks.coal_block,'R', Items.redstone});
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static CreativeTabs tabCheeseMod = new CreativeTabs("tabCheeseMod") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(itemCheese).getItem();
        }
    };

}

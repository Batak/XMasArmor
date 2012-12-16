package com.Batak.XmasArmor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.*;
import net.minecraft.src.*;


@Mod(modid="XMasArmor", name="XMasArmor", version="1.0 for MC 1.4.2")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class XmasArmor {

  public static Item RainbowCandy;
  public static Item SantaHelm;
  public static Item SantaPlate;
  public static Item SantaLegs;
  public static Item SantaBoots;
  public static Item WinterGirlHelm;
  public static Item WinterGirlPlate;
  public static Item WinterGirlLegs;
  public static Item WinterGirlBoots;
  public static Item Candy;
  public static Item CandySword;
  public static Item Shard;
  public static Item ShardPlate;
  public static Item CandyPickaxe;
  public static Item CandyShovel;
  public static Item CandyHoe;
  public static Item CandyAxe;
  public static int RainbowCandyID;
  public static int SantaHelmID;
  public static int SantaPlateID;
  public static int SantaLegsID;
  public static int SantaBootsID;
  public static int WinterGirlHelmID;
  public static int WinterGirlPlateID;
  public static int WinterGirlLegsID;
  public static int WinterGirlBootsID;
  public static int CandyID;
  public static int CandySwordID;
  public static int ShardID;
  public static int ShardPlateID;
  public static int CandyPickaxeID;
  public static int CandyShovelID;
  public static int CandyHoeID;
  public static int CandyAxeID;

        // The instance of your mod that Forge uses.
  @Instance("XMasArmor")
  public static XmasArmor instance;
       // This loads up your common and client proxies. change the location of the proxies and the public static to fit your setup
  @SidedProxy(clientSide="com.Batak.XmasArmor.ClientProxy", serverSide="com.Batak.XmasArmor.CommonProxy")
  public static CommonProxy proxy;
  
  static EnumToolMaterial SantaToolMaterial = EnumHelper.addToolMaterial("SantaMaterial", 3, 2000, 8F, 4, 25);// our material for craft
  static EnumArmorMaterial SantaArmorMaterial = EnumHelper.addArmorMaterial("SantaArmor", 40, new int[] {3, 8, 6, 3}, 25);//new material for armor
  @PreInit
  public void preInit(FMLPreInitializationEvent event) {
	  
      Configuration config = new Configuration(event.getSuggestedConfigurationFile()); //create config
      config.load();//load config
      	CandyID = config.getBlock("Candies", Configuration.CATEGORY_ITEM, 700).getInt();  
      	RainbowCandyID = config.getBlock("Rainbow Candy", Configuration.CATEGORY_ITEM, 701).getInt();
      	ShardID = config.getBlock("Shardes", Configuration.CATEGORY_ITEM, 702).getInt();
      	ShardPlateID = config.getBlock("Shard Plates", Configuration.CATEGORY_ITEM, 703).getInt();
        SantaHelmID = config.getBlock("Santa Helm", Configuration.CATEGORY_ITEM, 1000).getInt();
        SantaPlateID = config.getBlock("Santa Plate", Configuration.CATEGORY_ITEM, 1001).getInt();
        SantaLegsID = config.getBlock("Santa Legs", Configuration.CATEGORY_ITEM, 1002).getInt();
        SantaBootsID = config.getBlock("Santa Boots", Configuration.CATEGORY_ITEM, 1003).getInt();
        WinterGirlHelmID = config.getBlock("Winter Girl Helm", Configuration.CATEGORY_ITEM, 1004).getInt();
        WinterGirlPlateID = config.getBlock("Winter Girl Plate", Configuration.CATEGORY_ITEM, 1005).getInt();
        WinterGirlLegsID = config.getBlock("Winter Girl Legs", Configuration.CATEGORY_ITEM, 1006).getInt();
        WinterGirlBootsID = config.getBlock("Winter Girl Boots", Configuration.CATEGORY_ITEM, 1007).getInt();
        CandySwordID = config.getBlock("Candy Sword", Configuration.CATEGORY_ITEM, 1008).getInt();
        CandyPickaxeID = config.getBlock("Candy Pickaxe", Configuration.CATEGORY_ITEM, 1009).getInt();
        CandyShovelID = config.getBlock("Candy Shovel", Configuration.CATEGORY_ITEM, 1010).getInt();
        CandyHoeID = config.getBlock("Candy Hoe", Configuration.CATEGORY_ITEM, 1011).getInt();
        CandyAxeID = config.getBlock("Candy Axe", Configuration.CATEGORY_ITEM, 1012).getInt();
      config.save();//save config
      // this preinitialized your mod. when the mod gets preinted you can add things like system outputs.
  }
  
  @Init
  public void load(FMLInitializationEvent event){
	
	proxy.registerRenderers();
		
	Candy = new Candy (CandyID, 64).setItemName("Candy").setCreativeTab(CreativeTabs.tabMisc);
	LanguageRegistry.addName(new ItemStack(Candy, 1, 0), "Candy Non Color");
	LanguageRegistry.addName(new ItemStack(Candy, 1, 1), "Candy Red");
	LanguageRegistry.addName(new ItemStack(Candy, 1, 2), "Candy White");
	
	GameRegistry.addSmelting(Item.sugar.shiftedIndex, new ItemStack (Candy, 1, 0), 0.2F);
	GameRegistry.addShapelessRecipe(new ItemStack(Candy, 1, 1), new Object[]{new ItemStack(Candy, 1, 0), new ItemStack(Item.dyePowder, 1, 1)});
    GameRegistry.addShapelessRecipe(new ItemStack(Candy, 1, 2), new Object[]{new ItemStack(Candy, 1, 0), new ItemStack(Item.dyePowder, 1, 15)});
    
    RainbowCandy = new ItemFood(RainbowCandyID, 4, false).setAlwaysEdible().setPotionEffect(Potion.digSpeed.id, 10, 0, 1.0F).setCreativeTab(CreativeTabs.tabFood).setIconCoord(3, 0).setItemName("RainbowCandy");
    RainbowCandy.setTextureFile(CommonProxy.ITEMS_PNG);
    LanguageRegistry.addName(RainbowCandy, "\u00a74R\u00a76a\u00a72i\u00a79n\u00a71b\u00a75o\u00a74w \u00a76C\u00a72a\u00a79n\u00a71d\u00a75y");
    GameRegistry.addRecipe(new ItemStack(RainbowCandy, 1), new Object[]{"#@#", "  @", "  I", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.stick});
  	    
    Shard = new Shard (ShardID, 64).setItemName("Shard").setCreativeTab(CreativeTabs.tabMisc);
	LanguageRegistry.addName(new ItemStack(Shard, 1, 0), "\u00a71Blue Shard");
	LanguageRegistry.addName(new ItemStack(Shard, 1, 1), "\u00a74Red Shard");
	
	GameRegistry.addRecipe(new ItemStack(Shard, 1, 0), new Object[]{"@#@", "#I#", "@#@", '@', new ItemStack(Item.dyePowder, 1, 4), '#', new ItemStack(Candy, 1, 0), 'I', Item.diamond});
	GameRegistry.addRecipe(new ItemStack(Shard, 1, 1), new Object[]{"@#@", "#I#", "@#@", '@', Block.plantRed, '#', new ItemStack(Candy, 1, 0), 'I', Item.diamond});
    
	ShardPlate = new ShardPlate (ShardPlateID, 64).setItemName("ShardPlate").setCreativeTab(CreativeTabs.tabMisc);
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 0), "\u00a74Santa Right");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 0), new Object[]{"RRR", "@R ", "@  ", 'R', new ItemStack(Shard, 1, 1), '@', RainbowCandy});
	
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 1), "\u00a74Santa Left");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 1), new Object[]{"LL ", "LL@", "  @",  'L', new ItemStack(Shard, 1, 1), '@', RainbowCandy});
	
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 2), "\u00a74Santa Waistcoat");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 2), new Object[]{"@#@", "# #", "@#@", '#', new ItemStack(Shard, 1, 1), '@', RainbowCandy});
	
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 3), "\u00a71Winter Girl Right");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 3), new Object[]{"###", "@# ", "@  ", '#', new ItemStack(Shard, 1, 0), '@', RainbowCandy});
	
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 4), "\u00a71Winter Girl Left");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 4), new Object[]{"## ", "##@", "  @", '#', new ItemStack(Shard, 1, 0), '@', RainbowCandy});
	
	LanguageRegistry.addName(new ItemStack(ShardPlate, 1, 5), "\u00a71Winter Girl Waistcoat");
	GameRegistry.addRecipe(new ItemStack(ShardPlate, 1, 5), new Object[]{"@#@", "# #", "@#@", '#', new ItemStack(Shard, 1, 0), '@', RainbowCandy});
	
    SantaHelm = new SantaArmor(SantaHelmID, SantaArmorMaterial, 5, 0).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(4, 0).setItemName("SantaHelm");
    LanguageRegistry.addName(SantaHelm, "\u00a74Santa Helm");
    GameRegistry.addRecipe(new ItemStack(SantaHelm, 1), new Object[]{"###", "#@#", '#', new ItemStack(Shard, 1, 1), '@', Item.ingotGold});
    
    SantaPlate = new SantaArmor(SantaPlateID, SantaArmorMaterial, 5, 1).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(5, 0).setItemName("SantaPlate");
    LanguageRegistry.addName(SantaPlate, "\u00a74Santa Plate");
    GameRegistry.addRecipe(new ItemStack(SantaPlate, 1), new Object[]{"@#I", '@', new ItemStack(ShardPlate, 1, 1), '#', new ItemStack(ShardPlate, 1, 2), 'I',  new ItemStack(ShardPlate, 1, 0)});
    
    SantaLegs = new SantaArmor(SantaLegsID, SantaArmorMaterial, 5, 2).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(6, 0).setItemName("SantaLegs");
    LanguageRegistry.addName(SantaLegs, "\u00a74Santa Legs");
    GameRegistry.addRecipe(new ItemStack(SantaLegs, 1), new Object[]{"###", "#@#", "# #", '#', new ItemStack(Shard, 1, 1), '@', Item.ingotGold});
    
    SantaBoots = new SantaArmor(SantaBootsID, SantaArmorMaterial, 5, 3).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(7, 0).setItemName("SantaBoots");
    LanguageRegistry.addName(SantaBoots, "\u00a74Santa Boots");
    GameRegistry.addRecipe(new ItemStack(SantaBoots, 1), new Object[]{"#@#", "# #", '#', new ItemStack(Shard, 1, 1), '@', Item.ingotGold});
     
    WinterGirlHelm = new WinterGirlArmor(WinterGirlHelmID, SantaArmorMaterial, 6, 0).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(8, 0).setItemName("WinterGirlHelm");
    LanguageRegistry.addName(WinterGirlHelm, "\u00a71Winter Girl Helm");
    GameRegistry.addRecipe(new ItemStack(WinterGirlHelm, 1), new Object[]{"###", "#@#", '#', new ItemStack(Shard, 1, 0), '@', Item.ingotGold});

    WinterGirlPlate = new WinterGirlArmor(WinterGirlPlateID, SantaArmorMaterial, 6, 1).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(9, 0).setItemName("WinterGirlPlate");
    LanguageRegistry.addName(WinterGirlPlate, "\u00a71Winter Girl Plate");
    GameRegistry.addRecipe(new ItemStack(WinterGirlPlate, 1), new Object[]{"@#I", '@', new ItemStack(ShardPlate, 1, 4), '#', new ItemStack(ShardPlate, 1, 5), 'I',  new ItemStack(ShardPlate, 1, 3)});
    
    WinterGirlLegs = new WinterGirlArmor(WinterGirlLegsID, SantaArmorMaterial, 6, 2).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(10, 0).setItemName("WinterGirlLegs");
    LanguageRegistry.addName(WinterGirlLegs, "\u00a71Winter Girl Legs");
    GameRegistry.addRecipe(new ItemStack(WinterGirlLegs, 1), new Object[]{"###", "#@#", "# #", '#', new ItemStack(Shard, 1, 0), '@', Item.ingotGold});
    
    WinterGirlBoots = new WinterGirlArmor(WinterGirlBootsID, SantaArmorMaterial, 6, 3).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(11, 0).setItemName("WinterGirlBoots");
    LanguageRegistry.addName(WinterGirlBoots, "\u00a71Winter Girl Boots");
    GameRegistry.addRecipe(new ItemStack(WinterGirlBoots, 1), new Object[]{"#@#", "# #", '#', new ItemStack(Shard, 1, 0), '@', Item.ingotGold});
    
    CandySword = new CandySword(CandySwordID, SantaToolMaterial).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(12, 0).setItemName("CandySword");
    LanguageRegistry.addName(CandySword, "\u00a74C\u00a76a\u00a72n\u00a79d\u00a71y \u00a75S\u00a74w\u00a76o\u00a72r\u00a79d");
    GameRegistry.addRecipe(new ItemStack(CandySword, 1), new Object[]{"#I@", "@I#", " R ", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.diamond, 'R', RainbowCandy});
  
    CandyPickaxe = new CandyPickaxe(CandyPickaxeID, SantaToolMaterial).setCreativeTab(CreativeTabs.tabTools).setIconCoord(22, 0).setItemName("CandyPickaxe");
    LanguageRegistry.addName(CandyPickaxe, "\u00a74C\u00a76a\u00a72n\u00a79d\u00a71y \u00a75P\u00a74i\u00a76c\u00a72k\u00a79a\u00a71x\u00a75e");
    GameRegistry.addRecipe(new ItemStack(CandyPickaxe, 1), new Object[]{"III", "@R#", "#R@", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.diamond, 'R', RainbowCandy});
  
    CandyShovel = new CandyShovel(CandyShovelID, SantaToolMaterial).setCreativeTab(CreativeTabs.tabTools).setIconCoord(23, 0).setItemName("CandyShovel");
    LanguageRegistry.addName(CandyShovel, "\u00a74C\u00a76a\u00a72n\u00a79d\u00a71y \u00a75S\u00a74h\u00a76o\u00a72v\u00a79e\u00a71l");
    GameRegistry.addRecipe(new ItemStack(CandyShovel, 1), new Object[]{"#I@", "@R#", " R ", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.diamond, 'R', RainbowCandy});
  
    CandyHoe = new CandyHoe(CandyHoeID, SantaToolMaterial).setCreativeTab(CreativeTabs.tabTools).setIconCoord(24, 0).setItemName("CandyHoe");
    LanguageRegistry.addName(CandyHoe, "\u00a74C\u00a76a\u00a72n\u00a79d\u00a71y \u00a75H\u00a74o\u00a76e");
    GameRegistry.addRecipe(new ItemStack(CandyHoe, 1), new Object[]{" II", "@R#", "#R@", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.diamond, 'R', RainbowCandy});
  
    CandyAxe = new CandyAxe(CandyAxeID, SantaToolMaterial).setCreativeTab(CreativeTabs.tabTools).setIconCoord(25, 0).setItemName("CandyAxe");
    LanguageRegistry.addName(CandyAxe, "\u00a74C\u00a76a\u00a72n\u00a79d\u00a71y \u00a75A\u00a74x\u00a76e");
    GameRegistry.addRecipe(new ItemStack(CandyAxe, 1), new Object[]{" II", " RI", "#R@", '#', new ItemStack(Candy, 1, 1), '@', new ItemStack(Candy, 1, 2), 'I', Item.diamond, 'R', RainbowCandy});
  
  }

  @PostInit
  public void postInit(FMLPostInitializationEvent event) {
  // this is the post initialization.
  }
}
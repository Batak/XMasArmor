package com.Batak.XmasArmor;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ShardPlate extends Item{
	
	public static final String[] names = new String[] {"Santa Right hand plate", "Santa Left Hand Plate", "Santa Waistcoat", "Winter Girl Right hand plate", "Winter Girl Left hand plate", "Winter Girl Waistcoat"};

	public ShardPlate (int i, int j)
	{
		super(i);
		maxStackSize = j;
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	  
	public String getTextureFile()
	{
		return CommonProxy.ITEMS_PNG;
	}
	
	public int getIconFromDamage(int i){
		return i+16;
	}
	
	public String getItemNameIS(ItemStack stack){
		return super.getItemName() + "." + names[stack.getItemDamage()];
	}
	
	
	 @SideOnly(Side.CLIENT)
     public void getSubItems(int itemID, CreativeTabs tabs, List list){
              for(int i = 0; i < 6; ++i){
                     list.add(new ItemStack(itemID, 1, i));
              }
      }
	 
}

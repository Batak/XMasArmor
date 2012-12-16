package com.Batak.XmasArmor;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class Candy extends Item{
	
	public static final String[] names = new String[] {"Non color", "Red", "White"};

	public Candy (int i, int j)
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
		return i;
	}
	
	public String getItemNameIS(ItemStack stack){
		return super.getItemName() + "." + names[stack.getItemDamage()];
	}
	
	
	 @SideOnly(Side.CLIENT)
     public void getSubItems(int itemID, CreativeTabs tabs, List list){
              for(int i = 0; i < 3; ++i){
                     list.add(new ItemStack(itemID, 1, i));
              }
      }
	 
}

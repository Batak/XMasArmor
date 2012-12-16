package com.Batak.XmasArmor;

import net.minecraft.src.*;
import net.minecraftforge.*;
import net.minecraftforge.common.IArmorTextureProvider;


public class SantaArmor extends ItemArmor implements IArmorTextureProvider
  {
    
	public SantaArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k) 
	{
		super(i, enumarmormaterial, 0, k);
	}

	public String getTextureFile()
	{
		return CommonProxy.ITEMS_PNG;
	}
	public String getArmorTextureFile(ItemStack itemstack) {
		
		if (itemstack.itemID == XmasArmor.SantaLegs.shiftedIndex) 
		{
			return ("/com/Batak/XmasArmor/gfx/Winter_Boy_2.png");
		}
		if(itemstack.itemID == XmasArmor.SantaHelm.shiftedIndex || itemstack.itemID == XmasArmor.SantaPlate.shiftedIndex || itemstack.itemID == XmasArmor.SantaBoots.shiftedIndex)
		{
			return ("/com/Batak/XmasArmor/gfx/Winter_Boy_1.png");
		}
		    return ("/com/Batak/XmasArmor/gfx/Winter_Boy_2.png");
	}

  }

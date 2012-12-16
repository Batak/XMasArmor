package com.Batak.XmasArmor;

import net.minecraft.src.*;
import net.minecraftforge.*;
import net.minecraftforge.common.IArmorTextureProvider;


public class WinterGirlArmor extends ItemArmor implements IArmorTextureProvider
  {

    
	public WinterGirlArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k) 
	{
		super(i, enumarmormaterial, 0, k);
	}

	public String getTextureFile()
	{
		return CommonProxy.ITEMS_PNG;
	}
	public String getArmorTextureFile(ItemStack itemstack) {
		
		if (itemstack.itemID == XmasArmor.WinterGirlLegs.shiftedIndex) 
		{
			return ("/com/Batak/XmasArmor/gfx/Winter_Lady_2.png");
		}
		if(itemstack.itemID == XmasArmor.WinterGirlHelm.shiftedIndex || itemstack.itemID == XmasArmor.WinterGirlPlate.shiftedIndex || itemstack.itemID == XmasArmor.WinterGirlBoots.shiftedIndex)
		{
			return ("/com/Batak/XmasArmor/gfx/Winter_Lady_1.png");
		}
		    return ("/com/Batak/XmasArmor/gfx/Winter_Lady_2.png");
	}

  }

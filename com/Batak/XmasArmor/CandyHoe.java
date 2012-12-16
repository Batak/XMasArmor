package com.Batak.XmasArmor;

import net.minecraft.src.*;

public class CandyHoe extends ItemHoe 
  {
    public CandyHoe(int i, EnumToolMaterial SantaMaterial)
      {
        super(i, SantaMaterial);
      }
   
    public String getTextureFile()
      {
        return CommonProxy.ITEMS_PNG;
      }
  }
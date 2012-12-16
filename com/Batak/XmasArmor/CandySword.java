package com.Batak.XmasArmor;

import net.minecraft.src.*;

public class CandySword extends ItemSword 
  {
    public CandySword(int i, EnumToolMaterial SantaMaterial)
      {
        super(i, SantaMaterial);
      }
   
    public String getTextureFile()
      {
        return CommonProxy.ITEMS_PNG;
      }
  }
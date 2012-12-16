package com.Batak.XmasArmor;

import net.minecraft.src.*;

public class CandyShovel extends ItemSpade 
  {
    public CandyShovel(int i, EnumToolMaterial SantaMaterial)
      {
        super(i, SantaMaterial);
      }
   
    public String getTextureFile()
      {
        return CommonProxy.ITEMS_PNG;
      }
  }
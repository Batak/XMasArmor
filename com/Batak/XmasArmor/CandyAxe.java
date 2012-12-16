package com.Batak.XmasArmor;

import net.minecraft.src.*;

public class CandyAxe extends ItemAxe 
  {
    public CandyAxe(int i, EnumToolMaterial SantaMaterial)
      {
        super(i, SantaMaterial);
      }
   
    public String getTextureFile()
      {
        return CommonProxy.ITEMS_PNG;
      }
  }
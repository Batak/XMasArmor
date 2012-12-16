package com.Batak.XmasArmor;

import net.minecraft.src.*;

public class CandyPickaxe extends ItemPickaxe 
  {
    public CandyPickaxe(int i, EnumToolMaterial SantaMaterial)
      {
        super(i, SantaMaterial);
      }
   
    public String getTextureFile()
      {
        return CommonProxy.ITEMS_PNG;
      }
  }
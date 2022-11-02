/*    */ package net.hyzon.Maintain.GUI;
/*    */ 
/*    */ import net.hyzon.Maintain.MT;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class Items
/*    */ {
/* 15 */   MT c = (MT)MT.getPlugin(MT.class);
/*    */   
/*    */   public void OpenGUI(Player p) {
/* 18 */     Inventory i = Bukkit.getServer().createInventory(null, 9, 
/* 19 */         ChatColor.GREEN + "Maintenance " + ChatColor.GOLD + "v" + ChatColor.RED + this.c.version);
/*    */     
/* 21 */     ItemStack GWool = new ItemStack(Material.WOOL, 1, (short)5);
/* 22 */     ItemMeta GWoolM = GWool.getItemMeta();
/* 23 */     GWoolM.setDisplayName(ChatColor.GOLD + "Enabled!");
/* 24 */     GWool.setItemMeta(GWoolM);
/*    */     
/* 26 */     ItemStack RWool = new ItemStack(Material.WOOL, 1, (short)14);
/* 27 */     ItemMeta RWoolM = RWool.getItemMeta();
/* 28 */     RWoolM.setDisplayName(ChatColor.GOLD + "Disabled!");
/* 29 */     RWool.setItemMeta(RWoolM);
/*    */     
/* 31 */     ItemStack GGlass = new ItemStack(Material.STAINED_GLASS, 1, (short)5);
/* 32 */     ItemMeta GGlassM = GGlass.getItemMeta();
/* 33 */     GGlassM.setDisplayName(ChatColor.GOLD + "Enable Maintenance Mode.");
/* 34 */     GGlass.setItemMeta(GGlassM);
/*    */     
/* 36 */     ItemStack RGlass = new ItemStack(Material.STAINED_GLASS, 1, (short)14);
/* 37 */     ItemMeta RGlassM = RGlass.getItemMeta();
/* 38 */     RGlassM.setDisplayName(ChatColor.GOLD + "Disable Maintenance Mode.");
/* 39 */     RGlass.setItemMeta(RGlassM);
/*    */     
/* 41 */     ItemStack APAPER = new ItemStack(Material.PAPER, 1);
/* 42 */     ItemMeta APAPERM = APAPER.getItemMeta();
/* 43 */     APAPERM.setDisplayName(ChatColor.GOLD + "Add A Player!");
/* 44 */     APAPER.setItemMeta(APAPERM);
/*    */     
/* 46 */     ItemStack RPAPER = new ItemStack(Material.PAPER, 1);
/* 47 */     ItemMeta RPAPERM = RPAPER.getItemMeta();
/* 48 */     RPAPERM.setDisplayName(ChatColor.GOLD + "Remove A Player!");
/* 49 */     RPAPER.setItemMeta(RPAPERM);
/*    */     
/* 51 */     ItemStack LIST = new ItemStack(Material.SIGN, 1);
/* 52 */     ItemMeta LISTM = LIST.getItemMeta();
/* 53 */     LISTM.setDisplayName(ChatColor.GOLD + "Shows List");
/* 54 */     LIST.setItemMeta(LISTM);
/*    */     
/* 56 */     ItemStack RELOAD = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
/* 57 */     ItemMeta RELOADM = RELOAD.getItemMeta();
/* 58 */     RELOADM.setDisplayName(ChatColor.GOLD + "Reload Files.");
/* 59 */     RELOAD.setItemMeta(RELOADM);
/*    */     
/* 61 */     ItemStack INFO = new ItemStack(Material.WOOL, 1);
/* 62 */     ItemMeta INFOM = INFO.getItemMeta();
/* 63 */     INFOM.setDisplayName(ChatColor.GOLD + "Info");
/* 64 */     INFO.setItemMeta(INFOM);
/*    */     
/* 66 */     ItemStack OF = new ItemStack(Material.LEVER, 1);
/* 67 */     ItemMeta OFM = OF.getItemMeta();
/* 68 */     OFM.setDisplayName(ChatColor.GOLD + "Disable GUI Mode.");
/* 69 */     OF.setItemMeta(OFM);
/*    */     
/* 71 */     if (this.c.getConfig().getBoolean("enable")) {
/* 72 */       i.setItem(0, GWool);
/* 73 */       i.setItem(1, RGlass);
/*    */     } else {
/* 75 */       i.setItem(0, RWool);
/* 76 */       i.setItem(1, GGlass);
/*    */     } 
/*    */     
/* 79 */     i.setItem(2, APAPER);
/* 80 */     i.setItem(3, RPAPER);
/* 81 */     i.setItem(4, LIST);
/* 82 */     i.setItem(5, RELOAD);
/* 83 */     i.setItem(6, INFO);
/*    */     
/* 85 */     i.setItem(8, OF);
/*    */     
/* 87 */     p.openInventory(i);
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\GUI\Items.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
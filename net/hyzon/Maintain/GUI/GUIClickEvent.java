/*    */ package net.hyzon.Maintain.GUI;
/*    */ 
/*    */ import java.io.File;
/*    */ import net.hyzon.Maintain.MT;
/*    */ import net.hyzon.Maintain.Tasks;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ public class GUIClickEvent
/*    */   implements Listener
/*    */ {
/* 19 */   MT c = (MT)MT.getPlugin(MT.class);
/* 20 */   Items gui = new Items();
/*    */   
/*    */   @EventHandler
/*    */   public void C(InventoryClickEvent e) {
/* 24 */     if (e.getWhoClicked() instanceof Player && 
/* 25 */       e.getInventory().getName().equals(ChatColor.GREEN + "Maintenance " + ChatColor.GOLD + "v" + ChatColor.RED + this.c.version)) {
/* 26 */       Player p = (Player)e.getWhoClicked();
/* 27 */       ItemStack in = e.getCurrentItem();
/* 28 */       if (in == null || !in.hasItemMeta() || in.getType() == Material.AIR) {
/* 29 */         e.setCancelled(true);
/*    */         return;
/*    */       } 
/* 32 */       e.setCancelled(true);
/*    */       
/* 34 */       String gn = in.getItemMeta().getDisplayName();
/* 35 */       if (gn.equals(ChatColor.GOLD + "Disable GUI Mode.")) {
/* 36 */         p.closeInventory();
/* 37 */         this.c.getConfig().set("use-gui", Boolean.valueOf(false));
/* 38 */         this.c.saveConfig();
/* 39 */         p.sendMessage(ChatColor.GREEN + "GUI Mode disabled!");
/*    */       } 
/* 41 */       if (gn.equals(ChatColor.GOLD + "Enable Maintenance Mode.")) {
/* 42 */         this.c.getConfig().set("enable", Boolean.valueOf(true));
/* 43 */         this.c.saveConfig();
/* 44 */         this.gui.OpenGUI(p);
/* 45 */         p.sendMessage(this.c.getConfig().getString("messages.on1").replace("&", "§"));
/*    */       } 
/* 47 */       if (gn.equals(ChatColor.GOLD + "Disable Maintenance Mode.")) {
/* 48 */         this.c.getConfig().set("enable", Boolean.valueOf(false));
/* 49 */         this.c.saveConfig();
/* 50 */         this.gui.OpenGUI(p);
/* 51 */         p.sendMessage(this.c.getConfig().getString("messages.off1").replace("&", "§"));
/*    */       } 
/*    */       
/* 54 */       if (gn.equals(ChatColor.GOLD + "Add A Player!")) {
/* 55 */         p.closeInventory();
/* 56 */         this.c.AT.put(p.getName(), Boolean.valueOf(true));
/* 57 */         p.sendMessage(ChatColor.GREEN + "Type out the name you want to add, type " + ChatColor.RED + "cancel" + ChatColor.GREEN + " to cancel adding.");
/*    */       } 
/*    */       
/* 60 */       if (gn.equals(ChatColor.GOLD + "Remove A Player!")) {
/* 61 */         p.closeInventory();
/* 62 */         this.c.RT.put(p.getName(), Boolean.valueOf(true));
/* 63 */         p.sendMessage(ChatColor.GREEN + "Type out the name you want to remove, type " + ChatColor.RED + "cancel" + ChatColor.GREEN + " to cancel removing.");
/*    */       } 
/*    */       
/* 66 */       if (gn.equals(ChatColor.GOLD + "Shows List")) {
/* 67 */         p.closeInventory();
/* 68 */         p.sendMessage(ChatColor.GRAY + "List of player that are listed:\n" + 
/* 69 */             ChatColor.GRAY + "Admins:\n" + 
/* 70 */             ChatColor.DARK_GRAY + (new Tasks()).GlistA() + "\n" + 
/* 71 */             ChatColor.GRAY + "Users:\n" + 
/* 72 */             ChatColor.DARK_GRAY + (new Tasks()).Glist());
/*    */       } 
/* 74 */       if (gn.equals(ChatColor.GOLD + "Reload Files.")) {
/* 75 */         File config = new File("plugins/HyzonMaintenance/config.yml");
/* 76 */         File Allowed = new File("plugins/HyzonMaintenance/Allowed.yml");
/* 77 */         YamlConfiguration.loadConfiguration(config);
/* 78 */         YamlConfiguration.loadConfiguration(Allowed);
/* 79 */         p.sendMessage(this.c.getConfig().getString("messages.reload").replace("&", "§"));
/*    */       } 
/* 81 */       if (gn.equals(ChatColor.GOLD + "Info")) {
/* 82 */         p.closeInventory();
/* 83 */         p.sendMessage("§8 --- §7HyzonMaintenance §8---\n§8Author & Developer: §7Hyzon\n§8Version: §7" + 
/*    */             
/* 85 */             this.c.version + "\n" + 
/* 86 */             "§8 --- §7HyzonMaintenance §8---");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\GUI\GUIClickEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
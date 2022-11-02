/*    */ package net.hyzon.Maintain;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class CheckKick
/*    */   implements Listener {
/*    */   private MT c;
/*    */   
/*    */   public CheckKick(MT x) {
/* 13 */     this.c = x;
/*    */   }
/*    */   
/*    */   public void loop() {
/* 17 */     Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("HyzonMaintenance"), new Runnable() {
/*    */           public void run() {
/* 19 */             if (CheckKick.this.c.getConfig().getBoolean("enable")) {
/* 20 */               for (Player a : Bukkit.getOnlinePlayers()) {
/*    */                 
/* 22 */                 List<String> ul = (new Tasks()).Ulist();
/* 23 */                 List<String> ula = (new Tasks()).UlistA();
/*    */                 
/* 25 */                 if (!ul.contains(a.getName().toLowerCase()) && 
/* 26 */                   !ula.contains(a.getName().toLowerCase())) {
/* 27 */                   String kickM = CheckKick.this.c.getConfig().getString("messages.kick").replaceAll(":nl:", "\n").replace("&", "§");
/* 28 */                   a.kickPlayer(kickM);
/*    */                 }
/*    */               
/*    */               } 
/*    */             }
/*    */           }
/* 34 */         }100L, 100L);
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\CheckKick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
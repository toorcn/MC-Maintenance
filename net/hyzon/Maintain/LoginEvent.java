/*    */ package net.hyzon.Maintain;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ 
/*    */ public class LoginEvent
/*    */   implements Listener
/*    */ {
/*    */   private MT c;
/*    */   
/*    */   public LoginEvent(MT x) {
/* 14 */     this.c = x;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Login(PlayerLoginEvent e) {
/* 19 */     if (this.c.getConfig().getBoolean("enable")) {
/*    */       
/* 21 */       List<String> ul = (new Tasks()).Ulist();
/* 22 */       List<String> ula = (new Tasks()).UlistA();
/*    */       
/* 24 */       if (!ul.contains(e.getPlayer().getName().toLowerCase()) && 
/* 25 */         !ula.contains(e.getPlayer().getName().toLowerCase())) {
/* 26 */         String kickM = this.c.getConfig().getString("messages.kick").replaceAll(":nl:", "\n").replace("&", "§");
/* 27 */         e.disallow(PlayerLoginEvent.Result.KICK_OTHER, kickM);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\LoginEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
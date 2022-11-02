/*    */ package net.hyzon.Maintain.GUI;
/*    */ 
/*    */ import net.hyzon.Maintain.MT;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ public class LeaveEvent
/*    */   implements Listener
/*    */ {
/* 12 */   MT c = (MT)MT.getPlugin(MT.class);
/*    */   
/*    */   @EventHandler
/*    */   public void leave(PlayerQuitEvent e) {
/* 16 */     Player p = e.getPlayer();
/* 17 */     String name = p.getName();
/* 18 */     if (this.c.AT.containsKey(name) && ((Boolean)this.c.AT.get(name)).booleanValue()) {
/* 19 */       this.c.AT.remove(name);
/*    */     }
/* 21 */     if (this.c.RT.containsKey(name) && ((Boolean)this.c.RT.get(name)).booleanValue())
/* 22 */       this.c.RT.remove(name); 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\GUI\LeaveEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
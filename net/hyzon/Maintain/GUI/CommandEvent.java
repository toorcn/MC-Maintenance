/*    */ package net.hyzon.Maintain.GUI;
/*    */ 
/*    */ import net.hyzon.Maintain.MT;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*    */ 
/*    */ public class CommandEvent
/*    */   implements Listener
/*    */ {
/* 11 */   MT c = (MT)MT.getPlugin(MT.class);
/*    */   
/*    */   @EventHandler
/*    */   public void cm(PlayerCommandPreprocessEvent e) {
/* 15 */     String name = e.getPlayer().getName();
/* 16 */     if ((this.c.AT.containsKey(name) && ((Boolean)this.c.AT.get(name)).booleanValue()) || (
/* 17 */       this.c.RT.containsKey(name) && ((Boolean)this.c.RT.get(name)).booleanValue()))
/* 18 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\GUI\CommandEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
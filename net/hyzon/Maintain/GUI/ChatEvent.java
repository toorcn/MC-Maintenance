/*    */ package net.hyzon.Maintain.GUI;
/*    */ 
/*    */ import net.hyzon.Maintain.MT;
/*    */ import net.hyzon.Maintain.Tasks;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ public class ChatEvent
/*    */   implements Listener
/*    */ {
/* 13 */   MT c = (MT)MT.getPlugin(MT.class);
/* 14 */   Items gui = new Items();
/*    */   
/*    */   @EventHandler
/*    */   public void chat(AsyncPlayerChatEvent e) {
/* 18 */     Player p = e.getPlayer();
/* 19 */     String name = p.getName();
/*    */     
/* 21 */     String m = e.getMessage(); String[] arrayOfString;
/* 22 */     if (this.c.AT.containsKey(name) && ((Boolean)this.c.AT.get(name)).booleanValue() && (arrayOfString = m.split(" ")).length != 0) { String s = arrayOfString[0];
/* 23 */       String fnl = s;
/* 24 */       if (fnl.equalsIgnoreCase("cancel")) {
/* 25 */         this.c.AT.remove(name);
/* 26 */         this.gui.OpenGUI(p);
/* 27 */         e.setCancelled(true);
/*    */       } else {
/* 29 */         if ((new Tasks()).Exist(fnl)) {
/* 30 */           p.sendMessage(this.c.getConfig().getString("messages.addar").replace("&", "§"));
/*    */         } else {
/* 32 */           (new Tasks()).AP(fnl);
/* 33 */           p.sendMessage(this.c.getConfig().getString("messages.added").replace("&", "§"));
/*    */         } 
/* 35 */         e.setCancelled(true);
/* 36 */         this.c.AT.remove(name);
/* 37 */         this.gui.OpenGUI(p);
/*    */       }  }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 43 */     m = e.getMessage();
/* 44 */     if (this.c.RT.containsKey(name) && ((Boolean)this.c.RT.get(name)).booleanValue() && (arrayOfString = m.split(" ")).length != 0) { String s = arrayOfString[0];
/* 45 */       String fnl = s;
/* 46 */       if (fnl.equalsIgnoreCase("cancel")) {
/* 47 */         this.c.AT.remove(name);
/* 48 */         this.gui.OpenGUI(p);
/* 49 */         e.setCancelled(true);
/*    */       } else {
/* 51 */         if (!(new Tasks()).Exist(fnl)) {
/* 52 */           p.sendMessage(this.c.getConfig().getString("messages.removear").replace("&", "§"));
/*    */         } else {
/* 54 */           (new Tasks()).RP(fnl);
/* 55 */           p.sendMessage(this.c.getConfig().getString("messages.removed").replace("&", "§"));
/*    */         } 
/* 57 */         e.setCancelled(true);
/* 58 */         this.c.RT.remove(name);
/* 59 */         this.gui.OpenGUI(p);
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\GUI\ChatEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.hyzon.Maintain;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import net.hyzon.Maintain.GUI.ChatEvent;
/*    */ import net.hyzon.Maintain.GUI.CommandEvent;
/*    */ import net.hyzon.Maintain.GUI.GUIClickEvent;
/*    */ import net.hyzon.Maintain.GUI.LeaveEvent;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class MT
/*    */   extends JavaPlugin
/*    */ {
/* 15 */   public double version = 3.2D;
/*    */   
/* 17 */   Tasks tsk = new Tasks();
/*    */   
/* 19 */   public HashMap<String, Boolean> AT = new HashMap<>();
/* 20 */   public HashMap<String, Boolean> RT = new HashMap<>();
/*    */   
/*    */   public void onEnable() {
/* 23 */     getConfig().options().copyDefaults(true);
/* 24 */     saveConfig();
/* 25 */     getServer().getPluginManager().registerEvents(new LoginEvent(this), (Plugin)this);
/* 26 */     GUI();
/* 27 */     getCommand("mt").setExecutor(new Cmd());
/* 28 */     (new CheckKick(this)).loop();
/* 29 */     (new FileCreation()).Create();
/* 30 */     this.tsk.createSection1();
/* 31 */     this.tsk.createSection2();
/*    */   }
/*    */   
/*    */   public void GUI() {
/* 35 */     getServer().getPluginManager().registerEvents((Listener)new ChatEvent(), (Plugin)this);
/* 36 */     getServer().getPluginManager().registerEvents((Listener)new CommandEvent(), (Plugin)this);
/* 37 */     getServer().getPluginManager().registerEvents((Listener)new GUIClickEvent(), (Plugin)this);
/* 38 */     getServer().getPluginManager().registerEvents((Listener)new LeaveEvent(), (Plugin)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\MT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
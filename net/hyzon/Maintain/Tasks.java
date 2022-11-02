/*    */ package net.hyzon.Maintain;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ public class Tasks
/*    */ {
/* 13 */   File FL = new File("plugins/HyzonMaintenance/Allowed.yml");
/* 14 */   YamlConfiguration FC = YamlConfiguration.loadConfiguration(this.FL);
/*    */   
/*    */   public void createSection1() {
/* 17 */     if (this.FC.getString("Admins") == null) {
/* 18 */       this.FC.createSection("Admins");
/* 19 */       this.FC.set("Admins", Arrays.asList(new String[] { "ikr_" }));
/* 20 */       SF(this.FC);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void createSection2() {
/* 25 */     if (this.FC.getString("Users") == null) {
/* 26 */       this.FC.createSection("Users");
/* 27 */       SF(this.FC);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void AP(String name) {
/* 32 */     ArrayList<String> al = (ArrayList<String>)this.FC.getStringList("Users");
/* 33 */     al.add(name.toLowerCase());
/* 34 */     this.FC.set("Users", al);
/*    */     
/* 36 */     SF(this.FC);
/*    */   }
/*    */   
/*    */   public void RP(String name) {
/* 40 */     ArrayList<String> al = (ArrayList<String>)this.FC.getStringList("Users");
/* 41 */     al.remove(name.toLowerCase());
/* 42 */     this.FC.set("Users", al);
/*    */     
/* 44 */     SF(this.FC);
/*    */   }
/*    */   
/*    */   public boolean Exist(String name) {
/* 48 */     List<String> ul = this.FC.getStringList("Users");
/* 49 */     if (ul.contains(name.toLowerCase())) {
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ExistA(String name) {
/* 57 */     List<String> ul = this.FC.getStringList("Admins");
/* 58 */     if (ul.contains(name.toLowerCase())) {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String Glist() {
/* 66 */     return this.FC.getStringList("Users").toString().replace("[", "").replace("]", "");
/*    */   }
/*    */   
/*    */   public String GlistA() {
/* 70 */     return this.FC.getStringList("Admins").toString().replace("[", "").replace("]", "");
/*    */   }
/*    */   
/*    */   public List<String> Ulist() {
/* 74 */     return this.FC.getStringList("Users");
/*    */   }
/*    */   
/*    */   public List<String> UlistA() {
/* 78 */     return this.FC.getStringList("Admins");
/*    */   }
/*    */   
/*    */   public void SF(YamlConfiguration y) {
/*    */     try {
/* 83 */       y.save(this.FL);
/* 84 */     } catch (IOException e) {
/* 85 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\Tasks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
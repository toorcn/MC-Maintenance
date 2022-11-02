/*    */ package net.hyzon.Maintain;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class FileCreation
/*    */ {
/*  8 */   public static File DF = new File("plugins/HyzonMaintenance");
/*  9 */   public static File LN = new File("plugins/HyzonMaintenance/Allowed.yml");
/*    */   
/*    */   public void Create() {
/* 12 */     if (!DF.exists()) {
/*    */       try {
/* 14 */         DF.mkdir();
/* 15 */         DF.createNewFile();
/* 16 */       } catch (IOException e) {
/* 17 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 20 */     if (DF.exists() && 
/* 21 */       !LN.exists())
/*    */       try {
/* 23 */         LN.createNewFile();
/* 24 */       } catch (IOException e) {
/* 25 */         e.printStackTrace();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\FileCreation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
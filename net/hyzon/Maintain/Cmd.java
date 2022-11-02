/*     */ package net.hyzon.Maintain;
/*     */ 
/*     */ import java.io.File;
/*     */ import net.hyzon.Maintain.GUI.Items;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ 
/*     */ 
/*     */ public class Cmd
/*     */   implements CommandExecutor, Listener
/*     */ {
/*  17 */   MT c = (MT)MT.getPlugin(MT.class);
/*     */   
/*  19 */   String help = ChatColor.GRAY + "Maintain Help:\n" + 
/*  20 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt gui " + ChatColor.GOLD + "switches GUI mode.\n" + 
/*  21 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt on " + ChatColor.GOLD + "to turn on Maintenance.\n" + 
/*  22 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt off " + ChatColor.GOLD + "to turn off Maintenance.\n" + 
/*  23 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt add (player) " + ChatColor.GOLD + "allow a player to join while Maintenance is on.\n" + 
/*  24 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt remove (player) " + ChatColor.GOLD + "remove a player from the list.\n" + 
/*  25 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt list " + ChatColor.GOLD + "shows a list of players that are in the list.\n" + 
/*  26 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt reload " + ChatColor.GOLD + "reloads configuration file.\n" + 
/*  27 */     ChatColor.GRAY + " - " + ChatColor.GREEN + "/mt info " + ChatColor.GOLD + "infomation.";
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
/*  31 */     if (sender.isOp()) {
/*  32 */       if (!this.c.getConfig().getBoolean("use-gui") || !(sender instanceof Player)) {
/*  33 */         if (args.length == 1) {
/*     */           
/*  35 */           if (args[0].equalsIgnoreCase("gui")) {
/*  36 */             if (!this.c.getConfig().getBoolean("use-gui")) {
/*  37 */               this.c.getConfig().set("use-gui", Boolean.valueOf(true));
/*  38 */               this.c.saveConfig();
/*  39 */               sender.sendMessage(ChatColor.GREEN + "GUI Mode enabled!");
/*  40 */               if (sender instanceof Player) {
/*  41 */                 Player p = (Player)sender;
/*  42 */                 (new Items()).OpenGUI(p);
/*     */               } 
/*     */             } else {
/*  45 */               this.c.getConfig().set("use-gui", Boolean.valueOf(false));
/*  46 */               this.c.saveConfig();
/*  47 */               sender.sendMessage(ChatColor.GREEN + "GUI Mode disabled!");
/*     */             } 
/*     */           }
/*     */           
/*  51 */           if (args[0].equalsIgnoreCase("on")) {
/*  52 */             if (!this.c.getConfig().getBoolean("enable")) {
/*  53 */               this.c.getConfig().set("enable", Boolean.valueOf(true));
/*  54 */               this.c.saveConfig();
/*  55 */               sender.sendMessage(this.c.getConfig().getString("messages.on1").replace("&", "§"));
/*     */             } else {
/*  57 */               sender.sendMessage(this.c.getConfig().getString("messages.on2").replace("&", "§"));
/*     */             } 
/*     */           }
/*     */           
/*  61 */           if (args[0].equalsIgnoreCase("off")) {
/*  62 */             if (this.c.getConfig().getBoolean("enable")) {
/*  63 */               this.c.getConfig().set("enable", Boolean.valueOf(false));
/*  64 */               this.c.saveConfig();
/*  65 */               sender.sendMessage(this.c.getConfig().getString("messages.off1").replace("&", "§"));
/*     */             } else {
/*  67 */               sender.sendMessage(this.c.getConfig().getString("messages.off2").replace("&", "§"));
/*     */             } 
/*     */           }
/*     */           
/*  71 */           if (args[0].equalsIgnoreCase("list")) {
/*  72 */             sender.sendMessage(ChatColor.GRAY + "List of player that are listed:\n" + 
/*  73 */                 ChatColor.GRAY + "Admins:\n" + ChatColor.DARK_GRAY + (new Tasks()).GlistA() + "\n" + 
/*  74 */                 ChatColor.GRAY + "Users:\n" + ChatColor.DARK_GRAY + (new Tasks()).Glist());
/*     */           }
/*     */           
/*  77 */           if (args[0].equalsIgnoreCase("reload")) {
/*  78 */             File config = new File("plugins/HyzonMaintenance/config.yml");
/*  79 */             File Allowed = new File("plugins/HyzonMaintenance/Allowed.yml");
/*  80 */             YamlConfiguration.loadConfiguration(config);
/*  81 */             YamlConfiguration.loadConfiguration(Allowed);
/*  82 */             sender.sendMessage(this.c.getConfig().getString("messages.reload").replace("&", "§"));
/*     */           } 
/*     */           
/*  85 */           if (args[0].equalsIgnoreCase("info")) {
/*  86 */             sender.sendMessage("§8 --- §7HyzonMaintenance §8---\n§8Author & Developer: §7Hyzon\n§8Version: §7" + 
/*     */                 
/*  88 */                 this.c.version + "\n" + 
/*  89 */                 "§8 --- §7HyzonMaintenance §8---");
/*     */           }
/*     */           
/*  92 */           if (!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off") && 
/*  93 */             !args[0].equalsIgnoreCase("list") && !args[0].equalsIgnoreCase("reload") && 
/*  94 */             !args[0].equalsIgnoreCase("info") && !args[0].equalsIgnoreCase("gui")) {
/*  95 */             sender.sendMessage(this.help);
/*     */           }
/*     */         }
/*  98 */         else if (args.length == 2) {
/*     */           
/* 100 */           if (args[0].equalsIgnoreCase("add")) {
/* 101 */             if ((new Tasks()).Exist(args[1])) {
/* 102 */               sender.sendMessage(this.c.getConfig().getString("messages.addar").replace("&", "§"));
/*     */             } else {
/* 104 */               (new Tasks()).AP(args[1]);
/* 105 */               sender.sendMessage(this.c.getConfig().getString("messages.added").replace("&", "§"));
/*     */             } 
/*     */           }
/*     */           
/* 109 */           if (args[0].equalsIgnoreCase("remove")) {
/* 110 */             if (!(new Tasks()).Exist(args[1])) {
/* 111 */               sender.sendMessage(this.c.getConfig().getString("messages.removear").replace("&", "§"));
/*     */             } else {
/* 113 */               (new Tasks()).RP(args[1]);
/* 114 */               sender.sendMessage(this.c.getConfig().getString("messages.removed").replace("&", "§"));
/*     */             } 
/*     */           }
/*     */           
/* 118 */           if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
/* 119 */             sender.sendMessage(this.help);
/*     */           }
/*     */         } else {
/* 122 */           sender.sendMessage(this.help);
/*     */         } 
/*     */       } else {
/*     */         
/* 126 */         Player p = (Player)sender;
/* 127 */         (new Items()).OpenGUI(p);
/*     */       } 
/*     */     } else {
/* 130 */       sender.sendMessage("§8 --- §7HyzonMaintenance §8---\n§8Author & Developer: §7Hyzon\n§8Version: §7" + 
/*     */           
/* 132 */           this.c.version + "\n" + 
/* 133 */           "§8 --- §7HyzonMaintenance §8---");
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\hongb\Downloads\Maintenance (1).jar!\net\hyzon\Maintain\Cmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package net.poweredbyscience.taco;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by John on 2/20/2016.
 */
public class Taco extends JavaPlugin {

    String template = "hands {user} a {quality} {type} taco filled with {meat} and topped with {topping1}, {topping2} and {topping3}!"; //am too lazy don't judge
    String[] type = {"hard-shell", "soft-shell", "crispy", "puffy", "indian"};
    String[] quality = {"spicy", "mild", "delicious", "perfect"};
    String[] meat = {"minced beef", "shredded beef", "steak", "pork", "various meats", "chicken", "refried beans"};
    String[] topping = {"guacamole", "salsa", "sour cream", "cheese", "lettuce", "tomatoes", "avocado", "onion", "scallions", "jalapeños", "capsicum", "ghost chili", "minced-bacon"};

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("taco") && args.length == 1) {
            Bukkit.broadcastMessage(ChatColor.AQUA + sender.getName() + " " + prepareTaco(args[0]));
        }
        return true;
    }

    Random generator = new Random();

    public String prepareTaco(String user) { //string builder? What's that?
        return template.replace("{user}", user).replace("{type}", type[generator.nextInt(type.length)]).replace("{quality}", quality[generator.nextInt(quality.length)]).replace("{meat}", meat[generator.nextInt(meat.length)]).replace("{topping1}", topping[generator.nextInt(topping.length)]).replace("{topping2}", topping[generator.nextInt(topping.length)]).replace("{topping3}", topping[generator.nextInt(topping.length)]);
    }



}

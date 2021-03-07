package me.wolfyscript.customcrafting.data.patreon;

import me.wolfyscript.customcrafting.CustomCrafting;
import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Patreon {

    boolean isPatreon;

    List<Patron> patronList = new ArrayList<>();

    public Patreon(CustomCrafting customCrafting) {
        this.isPatreon = false;//!customCrafting.getDescription().getVersion().endsWith(".0");
    }

    public void initialize() {
        addPatron(new Patron("Nat R", "956faa3f-df9e-402b-bc13-39c03d4b4a5b", Tier.ELITE));
        addPatron(new Patron("Apprehentice", "db61eab0-7fb1-48db-986f-125e73787976", Tier.WOLFRAM));
        addPatron(new Patron("Alex", "af1ef7e4-acc3-44a1-8323-8f50b92be2c9", Tier.WOLFRAM));
        addPatron(new Patron("Junye Zhou", Tier.DIAMOND));
        addPatron(new Patron("Vincent Deniau", "a307c2b3-463a-4db6-8a6a-07419909af72", Tier.WOLFRAM));
        addPatron(new Patron("gizmonster", "e502d121-de9d-4f5d-b7e5-0da747c4e2e8", Tier.WOLFRAM));
        addPatron(new Patron("Thomas Texier", "5780bf01-16df-4f58-a768-1a78445f3d87", Tier.ELITE));
        addPatron(new Patron("John", Tier.WOLFRAM));
        addPatron(new Patron("HittmanA", Tier.WOLFRAM));
        addPatron(new Patron("CypherPhyre", Tier.WOLFRAM));
        addPatron(new Patron("Alexander", Tier.WOLFRAM));
        addPatron(new Patron("Vincent Fournier"));
        addPatron(new Patron("The Hound Brothers", Tier.WOLFRAM));
        addPatron(new Patron("Jason Asada", Tier.WOLFRAM));
        addPatron(new Patron("Inec Ackerr", Tier.WOLFRAM));
        addPatron(new Patron("伟铎 谢", Tier.WOLFRAM));
        addPatron(new Patron("ValentineDesigns"));
        addPatron(new Patron("Gleaks mania"));

        /*
        addPatron(new Patron("Arthur Neumann", Tier.WOLFRAM));
        addPatron(new Patron("Ananass Me", "a599af6e-7f60-4050-9854-92026e29d4d1", Tier.WOLFRAM));
        addPatron(new Patron("르 미"));
        addPatron(new Patron("Beng701"));
        addPatron(new Patron("Cameron R"));
        addPatron(new Patron("OTZ"));
        addPatron(new Patron("Eli2t"));
         */
    }

    private void addPatron(Patron patron) {
        patronList.add(patron);
    }

    public List<Patron> getPatronList() {
        return patronList;
    }

    public boolean isPatreon() {
        return isPatreon;
    }

    public enum Tier {
        WOLFRAM(ChatColor.GOLD), DIAMOND(ChatColor.AQUA), ELITE(ChatColor.LIGHT_PURPLE), LEGEND(ChatColor.RED);

        private final ChatColor chatColor;

        Tier(ChatColor chatColor) {
            this.chatColor = chatColor;
        }

        public ChatColor getColor() {
            return chatColor;
        }
    }

}
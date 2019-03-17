package me.wolfyscript.customcrafting.gui.items;

import me.wolfyscript.customcrafting.CustomCrafting;
import me.wolfyscript.customcrafting.data.PlayerCache;
import me.wolfyscript.customcrafting.data.cache.Items;
import me.wolfyscript.customcrafting.gui.ExtendedGuiWindow;
import me.wolfyscript.customcrafting.items.CustomItem;
import me.wolfyscript.customcrafting.items.ItemUtils;
import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.inventory.*;
import me.wolfyscript.utilities.api.utils.Legacy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemCreator extends ExtendedGuiWindow {

    public ItemCreator(InventoryAPI inventoryAPI) {
        super("item_creator", inventoryAPI, 54);
    }

    @Override
    public void onInit() {
        createItem("save_item", Material.WRITABLE_BOOK);
        createItem("apply_item", Material.GREEN_CONCRETE);

        createItem("item_name", Material.NAME_TAG);
        createItem("item_enchantments", Material.ENCHANTED_BOOK);
        createItem("item_lore", Material.WRITABLE_BOOK);
        createItem("item_flags", Material.WRITTEN_BOOK);
        createItem("attributes_modifiers", Material.ENCHANTED_GOLDEN_APPLE);
        createItem("unbreakable_on", Material.BEDROCK);
        createItem("unbreakable_off", Material.GLASS);
        createItem("skull_setting", Material.PLAYER_HEAD);
        createItem("potion_effects", Material.POTION);
        createItem("variants", Material.BOOKSHELF);

        createItem("potion_add", Material.GREEN_CONCRETE);
        createItem("potion_remove", Material.RED_CONCRETE);

        createItem("enchant_add", Material.ENCHANTED_BOOK);
        createItem("enchant_remove", Material.ENCHANTED_BOOK);
        createItem("lore_add", Material.WRITABLE_BOOK);
        createItem("lore_remove", Material.WRITTEN_BOOK);

        createItem("variant_add", Material.GREEN_CONCRETE);
        createItem("variant_remove", Material.RED_CONCRETE);
        createItem("up", WolfyUtilities.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFkNmM4MWY4OTlhNzg1ZWNmMjZiZTFkYzQ4ZWFlMmJjZmU3NzdhODYyMzkwZjU3ODVlOTViZDgzYmQxNGQifX19"));
        createItem("down", WolfyUtilities.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODgyZmFmOWE1ODRjNGQ2NzZkNzMwYjIzZjg5NDJiYjk5N2ZhM2RhZDQ2ZDRmNjVlMjg4YzM5ZWI0NzFjZTcifX19"));

        createItem("set_displayname", Material.GREEN_CONCRETE);
        createItem("remove_displayname", Material.RED_CONCRETE);

        createItem("skull_texture", Material.GREEN_CONCRETE);
        createItem("skull_owner", Material.NAME_TAG);

        createItem("flag_enchants", Material.ENCHANTING_TABLE);
        createItem("flag_attributes", Material.ENCHANTED_GOLDEN_APPLE);
        createItem("flag_unbreakable", Material.BEDROCK);
        createItem("flag_destroys", Material.TNT);
        createItem("flag_placed_on", Material.GRASS_BLOCK);
        createItem("flag_potion_effects", Material.POTION);

        createItem("attribute.generic_max_health", Material.ENCHANTED_GOLDEN_APPLE);
        createItem("attribute.generic_follow_range", Material.ENDER_EYE);
        createItem("attribute.generic_knockback_resistance", Material.STICK);
        createItem("attribute.generic_movement_speed", Material.IRON_BOOTS);
        createItem("attribute.generic_flying_speed", Material.FIREWORK_ROCKET);
        createItem("attribute.generic_attack_damage", Material.DIAMOND_SWORD);
        createItem("attribute.generic_attack_speed", Material.DIAMOND_AXE);
        createItem("attribute.generic_armor", Material.CHAINMAIL_CHESTPLATE);
        createItem("attribute.generic_armor_toughness", Material.DIAMOND_CHESTPLATE);
        createItem("attribute.generic_luck", Material.NETHER_STAR);
        createItem("attribute.horse_jump_strength", Material.DIAMOND_HORSE_ARMOR);
        createItem("attribute.zombie_spawn_reinforcements", Material.ZOMBIE_HEAD);

        createItem("attribute.add_number", WolfyUtilities.getSkullByValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBiNTVmNzQ2ODFjNjgyODNhMWMxY2U1MWYxYzgzYjUyZTI5NzFjOTFlZTM0ZWZjYjU5OGRmMzk5MGE3ZTcifX19"));
        createItem("attribute.add_scalar", WolfyUtilities.getSkullByValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTdiMTc5MWJkYzQ2ZDhhNWM1MTcyOWU4OTgyZmQ0MzliYjQwNTEzZjY0YjViYWJlZTkzMjk0ZWZjMWM3In19fQ=="));
        createItem("attribute.multiply_scalar_1", WolfyUtilities.getSkullByValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTlmMjdkNTRlYzU1NTJjMmVkOGY4ZTE5MTdlOGEyMWNiOTg4MTRjYmI0YmMzNjQzYzJmNTYxZjllMWU2OWYifX19"));

        createItem("attribute.slot_hand", Material.IRON_SWORD);
        createItem("attribute.slot_off_hand", Material.SHIELD);
        createItem("attribute.slot_feet", Material.IRON_BOOTS);
        createItem("attribute.slot_legs", Material.IRON_LEGGINGS);
        createItem("attribute.slot_chest", Material.IRON_CHESTPLATE);
        createItem("attribute.slot_head", Material.IRON_HELMET);

        createItem("attribute.save", Material.GREEN_CONCRETE);
        createItem("attribute.delete", Material.RED_CONCRETE);
        createItem("attribute.set_amount", WolfyUtilities.getSkullByValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYxYzhmZWJjYWMyMWI5ZjYzZDg3ZjlmZDkzMzU4OWZlNjQ2OGU5M2FhODFjZmNmNWU1MmE0MzIyZTE2ZTYifX19"));
        createItem("attribute.set_name", Material.NAME_TAG);
        createItem("attribute.set_uuid", Material.TRIPWIRE_HOOK);
    }

    @EventHandler
    public void onUpdate(GuiUpdateEvent event) {
        if (event.verify(this)) {
            PlayerCache cache = CustomCrafting.getPlayerCache(event.getPlayer());
            Items items = cache.getItems();

            event.setItem(4, "none", "glass_white");
            event.setItem(12, "none", "glass_white");
            event.setItem(13, items.getItem());
            event.setItem(14, "none", "glass_white");
            event.setItem(22, "none", "glass_white");

            if (!items.getType().equals("items")) {
                event.setItem(3, "apply_item");
            }
            event.setItem(5, "save_item");

            event.setItem(9, "item_name");
            event.setItem(10, "item_lore");

            event.setItem(18, "item_enchantments");
            event.setItem(19, "item_flags");

            event.setItem(20, "unbreakable_off");
            if (items.getItem() != null && items.getItem().hasItemMeta() && items.getItem().getItemMeta().isUnbreakable()) {
                event.setItem(20, "unbreakable_on");
            }

            event.setItem(16, "potion_effects");
            event.setItem(17, "attributes_modifiers");

            event.setItem(25, "variants");
            event.setItem(26, "skull_setting");

            CustomItem itemStack = items.getItem();
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (!itemStack.getType().equals(Material.AIR)) {
                //DRAW Sections
                switch (cache.getSubSetting()) {
                    case "item_name":
                        event.setItem(39, "set_displayname");
                        event.setItem(41, "remove_displayname");
                        break;
                    case "item_enchantments":
                        event.setItem(39, "enchant_add");
                        event.setItem(41, "enchant_remove");
                        break;
                    case "item_lore":
                        event.setItem(39, "lore_add");
                        event.setItem(41, "lore_remove");
                        break;
                    case "item_flags":
                        event.setItem(37, event.getItem("flag_attributes", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES) ? "§3" : "§4"));
                        event.setItem(39, event.getItem("flag_unbreakable", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE) ? "§3" : "§4"));
                        event.setItem(41, event.getItem("flag_destroys", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_DESTROYS) ? "§3" : "§4"));
                        event.setItem(43, event.getItem("flag_placed_on", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_PLACED_ON) ? "§3" : "§4"));
                        event.setItem(47, event.getItem("flag_potion_effects", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS) ? "§3" : "§4"));
                        event.setItem(51, event.getItem("flag_enchants", "%C%", itemMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS) ? "§3" : "§4"));
                        break;
                    case "attributes_modifiers":
                        event.setItem(36, "attribute.generic_max_health");
                        event.setItem(37, "attribute.generic_follow_range");
                        event.setItem(38, "attribute.generic_knockback_resistance");
                        event.setItem(39, "attribute.generic_movement_speed");
                        event.setItem(40, "attribute.generic_flying_speed");
                        event.setItem(41, "attribute.generic_attack_damage");
                        event.setItem(42, "attribute.generic_attack_speed");
                        event.setItem(43, "attribute.generic_armor");
                        event.setItem(44, "attribute.generic_armor_toughness");
                        event.setItem(48, "attribute.generic_luck");
                        event.setItem(49, "attribute.horse_jump_strength");
                        event.setItem(50, "attribute.zombie_spawn_reinforcements");
                        break;
                    case "skull_setting":
                        if (items.getItem().getType().equals(Material.PLAYER_HEAD)) {
                            event.setItem(38, items.getSkullSetting());
                            event.setItem(39, "skull_texture");
                            event.setItem(41, "skull_owner");
                        } else {
                            event.setItem(40, new ItemStack(Material.BARRIER));
                        }
                        break;
                    case "potion_effects":
                        if (itemMeta instanceof PotionMeta) {
                            event.setItem(39, "potion_add");
                            event.setItem(41, "potion_remove");
                        } else {
                            event.setItem(40, new ItemStack(Material.BARRIER));
                        }
                        break;
                    case "variants":
                        if (items.getType().equals("ingredient") || items.getType().equals("source")) {
                            event.setItem(30, "variant_add");
                            event.setItem(32, "variant_remove");
                            for (int i = 0; i < 7; i++) {
                                event.setItem(37 + i, new ItemStack(Material.AIR));
                            }
                            for (int i = 0; i < 7; i++) {
                                event.setItem(46 + i, new ItemStack(Material.AIR));
                            }
                            event.setItem(44, "up");
                            event.setItem(53, "down");
                        } else {
                            event.setItem(40, new ItemStack(Material.BARRIER));
                        }
                        break;
                }
                if (cache.getSubSetting().startsWith("GENERIC_") || cache.getSubSetting().startsWith("HORSE_") || cache.getSubSetting().startsWith("ZOMBIE_")) {

                    event.setItem(36, "attribute.slot_head");
                    event.setItem(45, "attribute.slot_chest");
                    event.setItem(37, "attribute.slot_legs");
                    event.setItem(46, "attribute.slot_feet");
                    event.setItem(38, "attribute.slot_hand");
                    event.setItem(47, "attribute.slot_off_hand");

                    if (items.getAttributeSlot() != null) {
                        ItemStack slotItem = event.getItem("attribute.slot_" + items.getAttributeSlot().name().toLowerCase());
                        slotItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
                        ItemMeta slotMeta = slotItem.getItemMeta();
                        slotMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        slotItem.setItemMeta(slotMeta);
                        switch (items.getAttributeSlot()) {
                            case HEAD:
                                event.setItem(36, slotItem);
                                break;
                            case CHEST:
                                event.setItem(45, slotItem);
                                break;
                            case LEGS:
                                event.setItem(37, slotItem);
                                break;
                            case FEET:
                                event.setItem(46, slotItem);
                                break;
                            case HAND:
                                event.setItem(38, slotItem);
                                break;
                            case OFF_HAND:
                                event.setItem(47, slotItem);
                        }
                    }

                    event.setItem(42, event.getItem("attribute.add_number", "%C%", items.getAttribOperation().equals(AttributeModifier.Operation.ADD_NUMBER) ? "§a" : "§4"));
                    event.setItem(43, event.getItem("attribute.add_scalar", "%C%", items.getAttribOperation().equals(AttributeModifier.Operation.ADD_SCALAR) ? "§a" : "§4"));
                    event.setItem(44, event.getItem("attribute.multiply_scalar_1", "%C%", items.getAttribOperation().equals(AttributeModifier.Operation.MULTIPLY_SCALAR_1) ? "§a" : "§4"));

                    event.setItem(51, event.getItem("attribute.set_amount", "%NUMBER%", String.valueOf(items.getAttribAmount())));
                    event.setItem(52, event.getItem("attribute.set_name", "%NAME%", items.getAttributeName()));
                    event.setItem(53, event.getItem("attribute.set_uuid", "%UUID%", items.getAttributeUUID()));

                    event.setItem(40, "attribute.save");
                    event.setItem(49, "attribute.delete");
                }

            }


        }
    }

    @Override
    public boolean onAction(GuiAction guiAction) {
        if (!super.onAction(guiAction)) {
            String action = guiAction.getAction();
            Player player = guiAction.getPlayer();
            PlayerCache cache = CustomCrafting.getPlayerCache(guiAction.getPlayer());
            Items items = cache.getItems();
            if (action.equals("back")) {
                guiAction.getGuiHandler().openLastInv();
            } else if (action.equals("save_item") && !items.getItem().getType().equals(Material.AIR)) {
                if (items.getType().equals("items") && CustomCrafting.getRecipeHandler().getCustomItem(items.getId()) != null) {
                    ItemUtils.saveItem(cache, items.getId(), items.getItem());
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.save.success$");
                    api.sendPlayerMessage(player, "&6" + items.getId().split(":")[0] + "/items/" + items.getId().split(":")[1]);
                } else {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.save.input.line1$");
                    runChat(0, "$msg.gui.item_creator.save.input.line2$", guiAction.getGuiHandler());
                }
            } else if (action.equals("apply_item") && !items.getItem().getType().equals(Material.AIR)) {
                CustomItem customItem = items.getItem();
                if (items.isSaved()) {
                    ItemUtils.saveItem(cache, items.getId(), customItem);
                    customItem = CustomCrafting.getRecipeHandler().getCustomItem(items.getId());
                }
                ItemUtils.applyItem(customItem, cache);
                guiAction.getGuiHandler().changeToInv("recipe_creator");
            } else {
                CustomItem itemStack = items.getItem();
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (!itemStack.getType().equals(Material.AIR) && itemMeta != null) {
                    switch (action) {
                        //TOP Section
                        case "skull_setting":
                        case "item_name":
                        case "item_lore":
                        case "item_flags":
                        case "attributes_modifiers":
                        case "item_enchantments":
                        case "potion_effects":
                        case "variants":
                            cache.setSubSetting(action);
                            break;
                        case "unbreakable_off":
                            itemMeta.setUnbreakable(true);
                            break;
                        case "unbreakable_on":
                            itemMeta.setUnbreakable(false);
                            break;

                        //Display name section
                        case "remove_displayname":
                            itemMeta.setDisplayName(null);
                            break;
                        case "set_displayname":
                            runChat(1, "$msg.gui.item_creator.display_name$", guiAction.getGuiHandler());
                            break;
                        //Enchantments
                        case "enchant_add":
                            runChat(2, "$msg.gui.item_creator.enchant.add$", guiAction.getGuiHandler());
                            break;
                        case "enchant_remove":
                            runChat(3, "$msg.gui.item_creator.enchant.remove$", guiAction.getGuiHandler());
                            break;

                        //LORE
                        case "lore_add":
                            runChat(4, "$msg.gui.item_creator.lore.add$", guiAction.getGuiHandler());
                            break;
                        case "lore_remove":
                            runChat(5, "$msg.gui.item_creator.lore.remove$", guiAction.getGuiHandler());
                            break;

                        //Potion
                        case "potion_add":
                            runChat(6, "$msg.gui.item_creator.potion.$", guiAction.getGuiHandler());
                            break;
                        case "potion_remove":
                            runChat(7, "$msg.gui.item_creator.potion.input$", guiAction.getGuiHandler());
                            break;

                        //VARIANTS
                        case "variant_add":

                            break;
                        case "variant_remove":

                            break;
                        //$gui.item_creator.$
                        //Attribute Settings
                        case "attribute.slot_head":
                        case "attribute.slot_chest":
                        case "attribute.slot_legs":
                        case "attribute.slot_feet":
                        case "attribute.slot_hand":
                        case "attribute.slot_off_hand":
                            EquipmentSlot equipmentSlot = EquipmentSlot.valueOf(action.substring("attribute.slot_".length()).toUpperCase());
                            if (items.getAttributeSlot() == null) {
                                items.setAttributeSlot(equipmentSlot);
                            } else {
                                items.setAttributeSlot(items.getAttributeSlot().equals(equipmentSlot) ? null : equipmentSlot);
                            }
                            break;
                        case "attribute.add_number":
                        case "attribute.add_scalar":
                        case "attribute.multiply_scalar_1":
                            items.setAttribOperation(AttributeModifier.Operation.valueOf(action.split("\\.")[1].toUpperCase()));
                            break;
                        case "attribute.set_amount":
                            runChat(8, "$msg.gui.item_creator.attribute.amount.input$", guiAction.getGuiHandler());
                            break;
                        case "attribute.set_name":
                            runChat(9, "$msg.gui.item_creator.attribute.name.input$", guiAction.getGuiHandler());
                            break;
                        case "attribute.set_uuid":
                            runChat(10, "$msg.gui.item_creator.attribute.uuid.input$", guiAction.getGuiHandler());
                            break;
                        case "attribute.save":
                            itemMeta.addAttributeModifier(Attribute.valueOf(cache.getSubSetting()), items.getAttributeModifier());
                            break;
                        case "attribute.delete":
                            if (itemMeta.hasAttributeModifiers()) {
                                itemMeta.removeAttributeModifier(Attribute.valueOf(cache.getSubSetting()), items.getAttributeModifier());
                            }
                            break;
                        //PLAYER SKULL SETTINGS
                        case "skull_texture":
                            if (guiAction.getClickedInventory().getItem(38) != null && guiAction.getClickedInventory().getItem(38).getType().equals(Material.PLAYER_HEAD)) {
                                ItemStack inputHead = guiAction.getClickedInventory().getItem(38);
                                itemMeta = WolfyUtilities.migrateSkullTexture((SkullMeta) inputHead.getItemMeta(), itemStack);
                            }
                            break;
                        case "skull_owner":
                            runChat(11, "$msg.gui.item_creator.skull_owner.input$", guiAction.getGuiHandler());
                    }

                    //Flag and attribute section
                    if (action.startsWith("flag_")) {
                        String attribute = action.split("_", 2)[1];
                        ItemFlag itemFlag = ItemFlag.valueOf("HIDE_" + attribute.toUpperCase());
                        if (!itemMeta.hasItemFlag(itemFlag)) {
                            itemMeta.addItemFlags(itemFlag);
                        } else {
                            itemMeta.removeItemFlags(itemFlag);
                        }
                    } else if (action.startsWith("attribute.generic") || action.startsWith("attribute.horse_") || action.startsWith("attribute.zombie_")) {
                        cache.setSubSetting(action.split("\\.")[1].toUpperCase());
                    }


                    itemStack.setItemMeta(itemMeta);
                    items.setItem(itemStack);
                    update(guiAction.getGuiHandler());

                }

            }

        }
        return true;
    }

    @Override
    public boolean onClick(GuiClick guiClick) {
        PlayerCache cache = CustomCrafting.getPlayerCache(guiClick.getPlayer());
        Bukkit.getScheduler().runTaskLater(CustomCrafting.getInst(), () -> {
            if (cache.getSubSetting().equals("skull_setting")) {
                ItemStack skull = guiClick.getPlayer().getOpenInventory().getTopInventory().getItem(38);
                if (skull != null) {
                    if (!skull.equals(guiClick.getGuiHandler().getItem("none", "glass_gray"))) {
                        cache.getItems().setSkullSetting(skull);
                    }
                } else {
                    cache.getItems().setSkullSetting(new ItemStack(Material.AIR));
                }
            }
            ItemStack item = guiClick.getPlayer().getOpenInventory().getTopInventory().getItem(13);
            cache.getItems().setItem(new CustomItem(item != null ? item : new ItemStack(Material.AIR)));
            update(guiClick.getGuiHandler());
        }, 1);
        return false;
    }

    @Override
    public boolean parseChatMessage(int id, String message, GuiHandler guiHandler) {
        Player player = guiHandler.getPlayer();
        PlayerCache cache = CustomCrafting.getPlayerCache(player);
        Items items = cache.getItems();
        String[] args = message.split(" ");
        ItemMeta itemMeta = items.getItem().getItemMeta();
        List<String> lore;
        PotionEffectType type;
        switch (id) {
            case 0:
                if (args.length > 1) {
                    ItemUtils.saveItem(cache, args[0] + ":" + args[1], items.getItem());

                    api.sendPlayerMessage(player, "$msg.gui.item_creator.save.success$");
                    api.sendPlayerMessage(player, "&6" + args[0] + "/items/" + args[1]);
                } else {
                    return true;
                }
                break;
            //DisplayName
            case 1:
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', message));
                items.getItem().setItemMeta(itemMeta);
                break;
            //Enchantments ADD
            case 2:
                if (args.length > 1) {
                    int level;
                    try {
                        level = Integer.parseInt(args[1]);
                    } catch (NumberFormatException ex) {
                        api.sendPlayerMessage(player, "$msg.gui.item_creator.enchant.invalid_lvl$");
                        return true;
                    }
                    Enchantment enchantment = Legacy.getEnchantment(args[0]);
                    if (enchantment != null) {
                        items.getItem().addUnsafeEnchantment(enchantment, level);
                    } else {
                        api.sendPlayerMessage(player, "$msg.gui.item_creator.enchant.invalid_enchant$", new String[]{"%ENCHANT%", args[0]});
                        return true;
                    }
                } else {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.enchant.no_lvl$");
                    return true;
                }
                break;
            //REMOVE
            case 3:
                Enchantment enchantment = Legacy.getEnchantment(args[0]);
                if (enchantment != null) {
                    items.getItem().removeEnchantment(enchantment);
                } else {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.enchant.invalid_enchant$", new String[]{"%ENCHANT%", args[0]});
                    return true;
                }
                break;
            //Lore ADD
            case 4:
                lore = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();
                lore.add(ChatColor.translateAlternateColorCodes('&', message));
                itemMeta.setLore(lore);
                items.getItem().setItemMeta(itemMeta);
                break;
            //REMOVE
            case 5:
                if (!itemMeta.hasLore()) {
                    return false;
                }
                int index;
                try {
                    index = Integer.parseInt(args[0]) - 1;
                } catch (NumberFormatException e) {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.lore.no_number$");
                    return true;
                }
                lore = itemMeta.getLore();
                if (lore.size() > index && !(index < 0)) {
                    lore.remove(index);
                } else {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.lore.error$", new String[]{"%NUM%", args[0]});
                    return true;
                }
                itemMeta.setLore(lore);
                items.getItem().setItemMeta(itemMeta);
                api.sendPlayerMessage(player, "$msg.gui.item_creator.lore.success$", new String[]{"%NUM%", args[0]});
                //Potion
            case 6:
                if (!(itemMeta instanceof PotionMeta)) {
                    return true;
                }
                type = null;
                int duration = 0;
                int amplifier = 1;
                boolean ambient = true;
                boolean particles = true;

                if (args.length >= 3) {
                    try {
                        type = Legacy.getPotion(args[0]);
                        duration = Integer.parseInt(args[1]);
                        amplifier = Integer.parseInt(args[2]);
                        if (args.length == 5) {
                            ambient = Boolean.valueOf(args[3].toLowerCase());
                            particles = Boolean.valueOf(args[4].toLowerCase());
                        }
                    } catch (NumberFormatException e) {
                        api.sendPlayerMessage(player, "$msg.gui.item_creator.potion.error_number$");
                        return true;
                    }
                }
                if (type != null) {
                    PotionEffect potionEffect = new PotionEffect(type, duration, amplifier, ambient, particles);
                    ((PotionMeta) itemMeta).addCustomEffect(potionEffect, true);

                    api.sendPlayerMessage(player, "$msg.gui.item_creator.potion.success$", new String[]{"%TYPE%", type.getName()}, new String[]{"%DUR%", String.valueOf(duration)}, new String[]{"%AMP%", String.valueOf(amplifier)}, new String[]{"%AMB%", String.valueOf(ambient)}, new String[]{"%PAR%", String.valueOf(particles)});
                    items.getItem().setItemMeta(itemMeta);
                    return false;

                }
                api.sendPlayerMessage(player, "$msg.gui.item_creator.potion.wrong_args$");
                return true;

            //REMOVE
            case 7:
                if (!(itemMeta instanceof PotionMeta)) {
                    return true;
                }
                type = Legacy.getPotion(args[0]);
                if (type != null) {
                    ((PotionMeta) itemMeta).removeCustomEffect(type);
                    items.getItem().setItemMeta(itemMeta);
                    return false;
                }
                api.sendPlayerMessage(player, "$msg.gui.item_creator.potion.invalid_name$", new String[]{"%NAME%", args[0]});
                return true;
            case 8:
                try {
                    items.setAttribAmount(Double.parseDouble(args[0]));
                } catch (NumberFormatException e) {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.attribute.amount.error$");
                    return true;
                }
                return false;
            case 9:
                items.setAttributeName(args[0]);
                return false;
            case 10:
                try {
                    UUID uuid = UUID.fromString(args[0]);
                    items.setAttributeUUID(uuid.toString());
                } catch (IllegalArgumentException ex) {
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.attribute.uuid.error.line1$", new String[]{"%UUID%", args[0]});
                    api.sendPlayerMessage(player, "$msg.gui.item_creator.attribute.uuid.error.line2$");
                    return true;
                }
                return false;
            case 11:
                if (!(itemMeta instanceof SkullMeta)) {
                    return true;
                }
                try {
                    UUID uuid = UUID.fromString(args[0]);
                    ((SkullMeta) itemMeta).setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
                } catch (IllegalArgumentException e) {
                    ((SkullMeta) itemMeta).setOwningPlayer(Bukkit.getOfflinePlayer(args[0]));
                }
                items.getItem().setItemMeta(itemMeta);


        }
        return false;
    }
}
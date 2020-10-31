package xyz.yarinlevi.baseplugin.messages;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.yarinlevi.baseplugin.BasePlugin;
import xyz.yarinlevi.baseplugin.classes.FileManager;

import java.io.File;
import java.util.HashMap;

public class MessageHandler {
    private final HashMap<String, String> messages = new HashMap<>();
    @Getter private final File file;
    @Getter private final FileConfiguration data;

    public MessageHandler() {
        file = new File(BasePlugin.instance.getDataFolder(), "messages.yml");
        data = YamlConfiguration.loadConfiguration(file);

        FileManager.registerData(file, data);
        ConfigurationSection messageSection = data.getConfigurationSection("messages");

        if (messageSection != null) {
            BasePlugin.instance.getLogger().warning("Loading messages..");
            messageSection.getKeys(false).forEach(key -> messages.put(key, ChatColor.translateAlternateColorCodes('&', messageSection.getString(key))));
            BasePlugin.instance.getLogger().info("Successfully loaded " + messages.size() + " messages out of " + messageSection.getKeys(false).size() + " messages.");
        } else {
            BasePlugin.instance.getLogger().severe("No messages were loaded! please check the file for errors.");
        }
    }

    public void testLoadedMessages() {
        StringBuilder stringBuilder = new StringBuilder("Loaded messages: \n");
        messages.forEach((key, value) -> stringBuilder.append(key).append(": ").append(value).append("\n"));
        BasePlugin.instance.getLogger().warning(stringBuilder.toString());
    }

    public void sendMessage(Player p, String messageKey) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, messages.get(messageKey))));
    }
}

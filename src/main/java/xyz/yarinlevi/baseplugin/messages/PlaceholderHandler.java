package xyz.yarinlevi.baseplugin.messages;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.yarinlevi.baseplugin.BasePlugin;

public class PlaceholderHandler extends PlaceholderExpansion {
    private final BasePlugin instance;

    public PlaceholderHandler(BasePlugin plugin) {
        this.instance = plugin;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "baseplugin";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Quapi";
    }

    @Override
    public @NotNull String getVersion() {
        return instance.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if(player == null){
            return "";
        }

        return null;
    }
}

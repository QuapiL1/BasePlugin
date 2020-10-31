package xyz.yarinlevi.baseplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.yarinlevi.baseplugin.BasePlugin;

public class TestMessages implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        BasePlugin.instance.messageHandler.testLoadedMessages();
        sender.sendMessage("DEBUG -> Please check console for more info!");
        return true;
    }
}

package xyz.yarinlevi.baseplugin.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.yarinlevi.baseplugin.BasePlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private final Map<String, QFile> files = new HashMap<>();
    private boolean autoSave = true; // Changeable by developer ONLY!

    public FileManager() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(BasePlugin.getInstance(), () -> {
            if (autoSave) {
                for (QFile qFile : files.values()) {
                    qFile.save();
                }
            }
        }, 0L, (20*300));
    }

    public QFile registerFile(String key, File file) {
        QFile qFile = new QFile(file);

        this.files.put(key, qFile);
        return qFile;
    }

    public void registerData(File file, FileConfiguration data) {
        if(!file.exists()) {
            file.getParentFile().mkdirs();
        } else {
            try {
                data.load(file);
            } catch (InvalidConfigurationException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

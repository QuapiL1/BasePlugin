package xyz.yarinlevi.baseplugin.files;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import xyz.yarinlevi.baseplugin.BasePlugin;

import java.io.File;
import java.io.IOException;

public class QFile {
    @Getter private final File file;
    @Getter private final FileConfiguration fileConfiguration;

    /**
     * Loading an unloaded file.
     * @param file The file you want to load
     */
    public QFile(File file) {
        this.file = file;
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);

        BasePlugin.getInstance().getFileManager().registerData(this.file, this.fileConfiguration);
    }

    /**
     * Injecting a file to the system
     * @param file Digital file
     * @param fileConfiguration The data from on the file.
     */
    public QFile(File file, FileConfiguration fileConfiguration) {
        this.file = file;
        this.fileConfiguration = fileConfiguration;
    }

    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package bingmclobby.Timmety;

import java.io.File;

public class configManager {

    public static void createConfig() {

        File file = new File("plugins//Lobby");
        if(!file.exists()) {
            file.mkdir();
        }


        File config = new File("plugins//Lobby//Config.yml");
        if(!config.exists()) {
            try {
                config.createNewFile();
            } catch(Exception e) {

            }

        }

    }

    public static File getConfig() {
        File config = new File("plugins//Lobby//Config.yml");
        return config;
    }

    public static File playersFile() {
        File config = new File("plugins//Lobby//Players");
        return config;

    }
}

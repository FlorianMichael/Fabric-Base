package de.enzaxd.fabricbase.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public record CustomWriter(ConfigContainer configContainer) {

    public void load() {
        for (AbstractConfig config : this.configContainer.configs()) {
            JsonObject jsonObject = new JsonObject();

            if (config.getFile().exists())
                try {
                    jsonObject = new Gson().fromJson(new FileReader(config.getFile()), JsonObject.class).getAsJsonObject();
                } catch (Exception e) {
                    jsonObject = new JsonObject();
                    e.printStackTrace();
                }

            config.loadAndSetDefaults(jsonObject);
        }
    }

    public void save() {
        for (AbstractConfig config : this.configContainer.configs()) {
            config.getFile().delete();

            try {
                config.getFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (final FileWriter fileWriter = new FileWriter(config.getFile())) {
                final Gson gson = new GsonBuilder().setPrettyPrinting().create();
                final JsonObject object = new JsonObject();

                config.save(object);
                fileWriter.write(gson.toJson(object));
                fileWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

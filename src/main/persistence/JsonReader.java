package persistence;

import model.Player;
import model.PlayersList;
import model.exceptions.EmptyNameException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represent a json reader.
public class JsonReader {
    private String source; // the source link

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads playersList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PlayersList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses playersList from JSON object and returns it
    private PlayersList parseWorkRoom(JSONObject jsonObject) {
        //String name = jsonObject.getString("name");
        //WorkRoom wr = new WorkRoom(name);
        PlayersList pl = new PlayersList();
        addPlayers(pl, jsonObject);

        //return wr;
        return pl;
    }

    // MODIFIES: pl
    // EFFECTS: parses players from JSON object and adds them to playersList.
    private void addPlayers(PlayersList pl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("PlayersList");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addPlayer(pl, nextThingy);
        }
    }

    // MODIFIES: pl
    // EFFECTS: parses name and score from JSON object and adds it to PlayersList.
    private void addPlayer(PlayersList pl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int score = jsonObject.getInt("score");
        Player player = null;
        try {
            player = new Player(name);
            player.setScore(score);
        } catch (EmptyNameException e) {
            System.out.println("Unexpected exceptions");
        }
        pl.addPlayer(player);
    }
}


package persistence;

import org.json.JSONObject;

// represent a JSON converter.
public interface Writable {
    JSONObject toJson();
}

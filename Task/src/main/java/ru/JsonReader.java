package ru;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.apache.commons.io.FileUtils;
import ru.model.Ticket;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    private static final String filePath = "C:\\Users\\29_06\\IdeaProjects\\Task\\src\\main\\java\\resources\\tickets.json";
    private static String exampleRequest;
    static {
        try {
            exampleRequest = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonReader() throws IOException {
    }


    public static List<Ticket> getTickets() throws IOException {
        return parseJsonArray(exampleRequest, Ticket.class);
    }


    public static <T> List<T> parseJsonArray(String json, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var tree = objectMapper.readTree(json);
        var list = new ArrayList<T>();
        for (JsonNode jsonNode : tree) {
            list.add(objectMapper.treeToValue(jsonNode, clazz));
        }
        return list;
    }

}


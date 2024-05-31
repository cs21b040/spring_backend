//curl -H 'Content-Type: application/json' \
// -d '{"contents":[
//     {"role": "user",
//       "parts":[{"text": "Give me five subcategories of jazz?"}]}]}' \
// "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=${API_KEY}"4
package com.example.backend.services;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeminiService {
    private String API=System.getenv("GEMINI_API_KEY");
    private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=";
    private RestTemplate restTemplate;
    public GeminiService() {
        this.restTemplate = new RestTemplate();
    }

    public String getResponse(String msg) throws JsonMappingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Map<String, Object> partsMap = new HashMap<>();
        partsMap.put("text", msg);
        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("parts", Arrays.asList(partsMap));
        Map<String, Object> body = new HashMap<>();
        body.put("contents", Arrays.asList(roleMap));
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(GEMINI_API_URL+API, HttpMethod.POST, entity, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode text = root.path("candidates").get(0).path("content").path("parts").get(0).path("text");
        return text.asText();
    
    }
}
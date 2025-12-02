package com.nurturejoy.NurtureJoy.chat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class OpenAIChatService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate rest = new RestTemplate();

    public String askOpenAI(String prompt) {

        try {
            String url = "https://api.openai.com/v1/chat/completions";

            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "gpt-4o-mini");
            requestBody.put("temperature", 0.7);

            requestBody.put("messages", new org.json.JSONArray()
                    .put(new JSONObject()
                            .put("role", "system")
                            .put("content", "You are Nurture Joy — a gentle pregnancy companion. "
                                    + "Give safe, supportive, non-medical general guidance only. "
                                    + "If medical advice is needed, tell them to contact a doctor."))
                    .put(new JSONObject()
                            .put("role", "user")
                            .put("content", prompt))
            );

            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.add("Authorization", "Bearer " + apiKey);
            headers.add("Content-Type", "application/json");

            org.springframework.http.HttpEntity<String> entity =
                    new org.springframework.http.HttpEntity<>(requestBody.toString(), headers);

            String response = rest.postForObject(url, entity, String.class);

            JSONObject json = new JSONObject(response);

            return json.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "I'm sorry, I had trouble responding. Please try again later.";
        }
    }
}
package com.nurturejoy.NurtureJoy.chat;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String replyTo(String question) {
        if (question == null || question.trim().isEmpty()) {
            return "I didn’t quite catch that. Could you type your question again, maybe with a bit more detail?";
        }

        String q = question.toLowerCase();

        // Very simple rule-based replies just for demo
        if (q.contains("nausea") || q.contains("vomit")) {
            return "Mild nausea can be common in pregnancy, especially in the first trimester. "
                 + "Try small, frequent meals and staying hydrated. However, if you can’t keep food or water down, "
                 + "or feel very weak, please contact your care provider or local health line.";
        }

        if (q.contains("back pain") || q.contains("backpain") || q.contains("back ache")) {
            return "Gentle stretching, good posture, and side-sleeping with a pillow between your knees can sometimes help with back pain. "
                 + "If the pain is severe, sudden, or worrying you, it’s important to speak with your doctor or midwife.";
        }

        if (q.contains("medicine") || q.contains("tablet") || q.contains("medication")) {
            return "For any questions about medicines during pregnancy, it’s safest to talk to your doctor, midwife, or pharmacist. "
                 + "Nurture Joy can’t prescribe or approve specific medications.";
        }

        if (q.contains("movement") || q.contains("kick")) {
            return "Baby’s movement can vary throughout the day. If you ever feel a clear decrease in movements compared to normal for you, "
                 + "please contact your care provider or local maternity triage line right away.";
        }

        if (q.contains("diet") || q.contains("food") || q.contains("eat")) {
            return "In general, a balance of whole grains, fruits, vegetables, protein, and plenty of water is supportive in pregnancy. "
                 + "Avoid foods your provider has told you to avoid, and reach out to them for personalised diet advice.";
        }

        // Default fallback
        return "Thank you for sharing your concern. Nurture Joy can offer general, gentle guidance, "
             + "but it cannot replace a real doctor or midwife. If this feels urgent or worrying, please contact your care provider or local emergency services.";
    }
}

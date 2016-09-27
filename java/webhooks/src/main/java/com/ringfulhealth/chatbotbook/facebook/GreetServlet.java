package com.ringfulhealth.chatbotbook.facebook;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class GreetServlet extends BaseServlet {

    public GreetServlet () {
        page_access_token = "EAAaCVHLqFzoBAEpCQQe4ZAOORZApsElw6mwsZCov9TGZBzs9OqZABWzqTkgtpOjepR5qZAEsOYJ2uZA1OuW8bddZCZBSuZCZAsMb1gam2ZCoHaua2m8Py1Sqph7DYv8e9t8l3KDi0Ok5jRQXsZB3615mb0oDqUASDmYMF0r1XsPeubUrcraB8tQZAcm5Eg";
    }

    public Object converse (String human, ConcurrentHashMap<String, Object> context) {
        System.out.println("GreetServlet converse");
        if (!context.containsKey("status")) {
            context.put("status", "wait_for_name");
            return "Hello! What is your name? Please enter firstname lastname";
        }

        if ("wait_for_name".equalsIgnoreCase((String) context.get("status"))) {
            context.put("name", human);
            context.put("status", "wait_for_gender");

            try {
                return createQuickReplies(
                        "It is great meeting you! What is your gender?",
                        new HashMap<String, String>(){{
                            put("Female", "F");
                            put("Male", "M");
                            put("Other", "O");
                        }}
                );

                /*
                JSONObject payload = createButtons(
                        "It is great meeting you! What is your gender?",
                        new HashMap<String, String>(){{
                            put("Female", "F");
                            put("Male", "M");
                            put("Other", "O");
                        }}
                );
                return payload;
                */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ("wait_for_gender".equalsIgnoreCase((String) context.get("status"))) {
            String salutation = "";
            if (human.toUpperCase().startsWith("F")) {
                salutation = "Ms. ";
            } else if (human.toUpperCase().startsWith("M")) {
                salutation = "Mr. ";
            } else if (human.toUpperCase().startsWith("O")) {
                salutation = "";
            } else {
                context.put("status", "wait_for_gender");
                return "Sorry, I did not get it. Please reply Female, Male, or Other";
            }

            context.remove("status");
            return "Hello, " + salutation + context.get("name");
        }

        return null;
    }

}

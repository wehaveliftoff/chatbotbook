package com.ringfulhealth.chatbotbook.facebook;

import java.util.concurrent.ConcurrentHashMap;

public class EchoServlet extends BaseServlet {

    public EchoServlet () {
        page_access_token = "EAAaCVHLqFzoBAEpCQQe4ZAOORZApsElw6mwsZCov9TGZBzs9OqZABWzqTkgtpOjepR5qZAEsOYJ2uZA1OuW8bddZCZBSuZCZAsMb1gam2ZCoHaua2m8Py1Sqph7DYv8e9t8l3KDi0Ok5jRQXsZB3615mb0oDqUASDmYMF0r1XsPeubUrcraB8tQZAcm5Eg";
    }

    public Object converse (String human, ConcurrentHashMap<String, Object> context) {
        System.out.println("EchoServlet converse");
        return human;
    }

}
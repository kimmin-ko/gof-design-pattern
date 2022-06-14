package com.study.designpatterns.min_kim._19_observer._2_after;

import java.util.*;

public class ChatServer {

    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void register(String subject, Subscriber subscriber) {
        if (subscribers.containsKey(subject)) {
            subscribers.get(subject).add(subscriber);
            return;
        }

        List<Subscriber> list = new ArrayList<>();
        list.add(subscriber);
        subscribers.put(subject, list);
    }

    public void unregister(String subject, Subscriber subscriber) {
        if (subscribers.containsKey(subject)) {
            subscribers.get(subject).remove(subscriber);
        }
    }

    public void sendMessage(User user, String subject, String message) {
        if (subscribers.containsKey(subject)) {
            String userMessage = user.getName() + ": " + message;
            subscribers.get(subject).forEach(subscriber -> subscriber.handleMessage(userMessage));
        }
    }
}

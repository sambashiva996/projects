package com.core.java.programs.practical;

import lombok.Getter;

import java.util.*;

public class EventSubscribePublishByObserverPattern {

    public static void main(String[] args) {
        /*
        * Create notifications using an Observer Pattern and like event subscribes,
        * and if a user subscribes they will get only subscribed event in java
        * */

        EventManager eventManager = new EventManager();

        UserDemo user1 = new UserDemo("user1");
        UserDemo user2 = new UserDemo("user2");

        //User subscribed for events below
        eventManager.subscribe(NewMessageEvent.class, user1);
        eventManager.subscribe(TimeReminderEvent.class, user2);

        //send notification to User
        eventManager.publish(new NewMessageEvent("Hi this is Message event"));
        eventManager.publish(new TimeReminderEvent("Hi this is Time Reminder Message event"));

    }

}

class EventManager{

    private final Map<Class<? extends EventDemo>, List<EventListener>> subscribers = new HashMap<>();

    public void subscribe(Class<? extends EventDemo> eventType, EventListener eventListener) {
           subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(eventListener);
    }

    public void publish(EventDemo eventDemo) {

        List<EventListener> eventListenerList = subscribers.get(eventDemo.getClass());
        if (Objects.nonNull(eventListenerList)){
            for (EventListener eventListener : eventListenerList){
                eventListener.onEvent(eventDemo);
            }
        }

    }
}

interface EventDemo{
}

interface EventListener extends EventDemo{
    void onEvent(EventDemo eventDemo);
}

class UserDemo implements EventListener{
    private String name;
    public UserDemo(String user) {
        this.name = user;
    }

    @Override
    public void onEvent(EventDemo eventDemo) {
        if (eventDemo instanceof NewMessageEvent){
        System.out.println("message received :"+((NewMessageEvent)eventDemo).getMessage());
        } else if (eventDemo instanceof TimeReminderEvent) {
            System.out.println("time message received :"+((TimeReminderEvent)eventDemo).getMessage());
        }
    }
}

@Getter
class NewMessageEvent implements EventDemo{

    private final String message;
    public NewMessageEvent(String message) {
        this.message = message;
    }
}

@Getter
class TimeReminderEvent implements EventDemo{
    private final String message;
    public TimeReminderEvent(String message) {
        this.message = message;
    }
}
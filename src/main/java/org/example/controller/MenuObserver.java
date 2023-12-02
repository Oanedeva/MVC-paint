package org.example.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuObserver  {
        Set<ActionListener> listenerSet=new HashSet<>();

    public static void notifyAllSubscribers() {
        for (ActionListener event:) {

        }
    }

    void subscribe(ActionListener listener){listenerSet.add(listener);}
        void unsubscribe(ActionListener listener){listenerSet.remove(listener);}
        /*void notifyAllObservers(String data){
            for(ActionListener event: listenerSet){
                event.update(data);
            }
        }*/
}

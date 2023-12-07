package org.example.controller;

import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component
public class MenuObserver {
        Set<MenuSubscribe> listenerSet=new HashSet<>();
    void subscribe(MenuSubscribe listener){listenerSet.add(listener);}
        void unsubscribe(MenuSubscribe listener){listenerSet.remove(listener);}
        void notifyAllSubscribers(){
            for(MenuSubscribe event: listenerSet){
                event.notifyUpdate();
            }
        }
}

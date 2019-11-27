package mvc;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable
{
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        this.observers.add(o);
    }

    public void clearObservers(){
        observers.clear();
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update();
        }
    }
}

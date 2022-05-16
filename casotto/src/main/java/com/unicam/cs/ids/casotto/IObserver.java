package com.unicam.cs.ids.casotto;

import java.util.Observer;

public interface IObserver {

    public void register(IObserver o);

    public void unregister(IObserver o);

    public void notifyObservers();

    public void update();
}

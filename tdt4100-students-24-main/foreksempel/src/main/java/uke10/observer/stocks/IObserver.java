package uke10.observer.stocks;

public interface IObserver {
    public void update(IObservable subject, String what);
}

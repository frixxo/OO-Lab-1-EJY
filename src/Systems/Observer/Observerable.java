package Systems.Observer;

public interface Observerable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObersers();
}

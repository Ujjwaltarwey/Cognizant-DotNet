import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    // Subject Interface
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // Observer Interface
    interface Observer {
        void update(String stockName, double price);
    }

    // Concrete Subject
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, price);
            }
        }

        public void setStock(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
            notifyObservers();
        }
    }

    // Concrete Observer - Mobile App
    static class MobileApp implements Observer {
        @Override
        public void update(String stockName, double price) {
            System.out.println("Mobile App: " + stockName + " price updated to Rs. " + price);
        }
    }

    // Concrete Observer - Web App
    static class WebApp implements Observer {
        @Override
        public void update(String stockName, double price) {
            System.out.println("Web App: " + stockName + " price updated to Rs. " + price);
        }
    }

    // Test
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("Stock Price Changed:");
        stockMarket.setStock("TCS", 3850.50);

        System.out.println("\nAfter Removing Web App:");
        stockMarket.deregisterObserver(web);

        stockMarket.setStock("Infosys", 1625.75);
    }
}
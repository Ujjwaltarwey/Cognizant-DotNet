public class ProxyPatternExample {

    // Subject Interface
    interface Image {
        void display();
    }

    // Real Subject
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading " + fileName + " from remote server...");
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    // Proxy Class
    static class ProxyImage implements Image {
        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            // Lazy Initialization + Caching
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    // Test
    public static void main(String[] args) {

        Image image = new ProxyImage("Nature.jpg");

        System.out.println("First Call:");
        image.display();

        System.out.println("\nSecond Call:");
        image.display();
    }
}
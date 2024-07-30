public class ProxyPatternExample {
    public static void main(String[] args) {
        Image pic1 = new ProxyImage("Photo.jpg");
        Image pic2 = new ProxyImage("Photo.jpg");

        pic1.display();
        System.out.println();
        pic1.display();
        System.out.println();
        pic2.display();
        System.out.println();
        pic2.display();
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading " + filename + " from remote server...");
        }

        @Override
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private final String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }
}

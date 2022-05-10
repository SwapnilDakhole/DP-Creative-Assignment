
//    1.	Image.java
    public interface Image {
        void display();
    }

//2.	RealImage.java
    public class RealImage implements Image {
        private String fileName;
        public RealImage(String fileName){
            this.fileName = fileName;
            loadFromDisk(fileName);
        }
        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }
        private void loadFromDisk(String fileName){
            System.out.println("Loading " + fileName);
        }
    }
//3.	ProxyImage.java
    public class ProxyImage implements Image{
        private RealImage realImage;
        private String filename;
        public ProxyImage(String fileName){
            this.fileName = fileName;
        }
        @Override
        public void display() {
            if(realImage == null){
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }
//	ProxyPatternDemo.java
    public class ProxyDesginDemo {
        public static void main(String[] args) {
            Image image = new ProxyImage("test_10mb.jpg");
            image.display();
            System.out.println("");
            image.display();
        }
    }



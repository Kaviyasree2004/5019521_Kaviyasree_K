class Computer {
    private final String CPU;
    private final int RAM;
    private final int storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gComp = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(2000)
                .build();

        Computer offComp = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(16)
                .setStorage(512)
                .build();

        System.out.println("Configuration of Gaming Computer:");
        System.out.println("CPU: " + gComp.getCPU());
        System.out.println("RAM: " + gComp.getRAM() + "GB");
        System.out.println("Storage: " + gComp.getStorage() + "GB");

        System.out.println("\nConfiguration of Office Computer:");
        System.out.println("CPU: " + offComp.getCPU());
        System.out.println("RAM: " + offComp.getRAM() + "GB");
        System.out.println("Storage: " + offComp.getStorage() + "GB");
    }
}

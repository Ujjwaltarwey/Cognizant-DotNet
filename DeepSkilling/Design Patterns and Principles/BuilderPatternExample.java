public class BuilderPatternExample {

    static class Computer {
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;
        private String OperatingSystem;

        
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GPU = builder.GPU;
            this.OperatingSystem = builder.OperatingSystem;
        }

        public void displayConfiguration() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + Storage);
            System.out.println("GPU: " + GPU);
            System.out.println("Operating System: " + OperatingSystem);
            System.out.println("----------------------------");
        }

        
        static class Builder {
            private String CPU;
            private String RAM;
            private String Storage;
            private String GPU;
            private String OperatingSystem;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String Storage) {
                this.Storage = Storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setOperatingSystem(String OperatingSystem) {
                this.OperatingSystem = OperatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .setGPU("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16 GB")
                .setStorage("512 GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        gamingPC.displayConfiguration();
        officePC.displayConfiguration();
    }
}
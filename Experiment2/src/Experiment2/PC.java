package Experiment2;

class PC {
    private CPU cpu;
    private HardDisk HD;

    PC() {

        System.out.println("Use default constructor");
        cpu = new CPU();
        HD = new HardDisk();
    }

    PC(CPU c , HardDisk hd) {
        cpu = c;
        HD = hd;
    }

    public void setCpu(CPU c) {
        cpu.setSpeed(c.getSpeed());
        cpu.setBrand(c.getBrand());
    }

    public void setHD(HardDisk hd) {
        HD.setAmount(hd.getAmount());
    }


    public void show() {
        System.out.println("Cpu speed: " + cpu.getSpeed());
        System.out.println("Cpu brand: " + cpu.getBrand());
        System.out.println("Hard Disk amount: " + HD.getAmount());
    }
}

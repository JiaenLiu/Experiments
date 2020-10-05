class PC {
    private CPU cpu;
    private HardDisk HD;

    PC() {
        cpu = new CPU();
        HD = new HardDisk();
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

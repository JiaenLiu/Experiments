public class Test {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.setSpeed(2200);
        cpu.setBrand("Inter");
        HardDisk hd = new HardDisk();
        hd.setAmount(200);
        PC pc = new PC();
        pc.setCpu(cpu);
        pc.setHD(hd);
        pc.show();
    }
}

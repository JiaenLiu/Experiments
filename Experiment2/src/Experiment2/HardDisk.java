package Experiment2;

class HardDisk {
    private int amount;

    HardDisk() {
        System.out.println("Use default constructor");
        amount = 0;
    }

    HardDisk(int Amount) {
        System.out.println("Use custom constructor");
        if (Amount < 0) {
            System.out.println("Initial1 amount failed");
            return;
        }
        amount = Amount;
    }

    public void setAmount(int amount1) {

        if (amount1 < 0) {
            System.out.println("Set amount failed");
            return;
        }

        amount = amount1;
    }

    public int getAmount() {
        return amount;
    }
}

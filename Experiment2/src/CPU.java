class CPU {
    private int Speed;
    private String Brand;


    CPU() {
        Speed = 0;
    }

    CPU(int Speed, String brand) {
        if (Speed < 0) {
            System.out.println("Initial speed failed");
            return;
        }
        if (!brand.equals("Inter") && !brand.equals("AMD")) {
            Brand = "Others";
            return;
        }
        this.Speed = Speed;
        Brand = brand;
    }

    public void setBrand(String brand) {
        if (!brand.equals("Inter") && !brand.equals("AMD")) {
            Brand = "Others";
            return;
        }
        Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

    public void setSpeed(int speed1) {

        if (speed1 < 0) {
            System.out.println("Set speed failed");
            return;
        }
        Speed = speed1;
    }

    public int getSpeed() {
        return Speed;
    }

}

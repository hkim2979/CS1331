public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = (droolRate <= 0) ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return this.droolRate;
    }

    public int treat() {
        int treatmentTime;
        if (droolRate < 3.5) {
            treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        }
        else if (droolRate <= 7.5) {
            treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
        }
        else {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return  treatmentTime;
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "BARK " : "bark ";
        String output = "";
        for (int i = 1; i <= getPainLevel(); i++) {
            output = output + sound;
        }
        System.out.println(output.trim());
    }

    public boolean equals(Object o) {
        return (super.equals(o) && (((Dog) o).droolRate == droolRate));
    }
}
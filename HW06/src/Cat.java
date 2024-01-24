public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    public int treat() {
        int treatmentTime;
        if (miceCaught < 4) {
            treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        }
        else if (miceCaught <= 7) {
            treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
        }
        else {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return treatmentTime;
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "MEOW " : "meow ";
        String output = "";
        for (int i = 1; i <= miceCaught; i++) {
            output = output + sound;
        }
        System.out.println(output.trim());
    }

    public boolean equals(Object o) {
        return (super.equals(o) && (((Cat) o).miceCaught == miceCaught));
    }
}
public abstract class Pet {
    //Declaring variables
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health > 1.0) {
            this.health = 1.0;
        }
        else if (health <= 0.0) {
            this.health = 0.0;
        }
        else {
            this.health = health;
        }

        if (painLevel >= 10) {
            this.painLevel = 10;
        }
        else if (painLevel <= 1) {
            this.painLevel = 1;
        }
        else {
            this.painLevel = painLevel;
        }
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public abstract int treat();

    public void speak() {
        String output = String.format("Hello! My name is %s", name);
        output = (painLevel > 5) ? output.toUpperCase() : output;
        System.out.println(output);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet2 = (Pet) o;
        return (pet2.name.equals(name));
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }
}
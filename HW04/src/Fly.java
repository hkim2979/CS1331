public class Fly {

    //Assign private variable
    private double mass;
    private double speed;

    //Constructor
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {

        this(mass, 10);
    }

    public Fly() {

        this(5, 10);
    }

    //getters and setters

    public double getMass() {

        return mass;
    }
    public void setMass(double mass) {

        this.mass = mass;
    }

    public double getSpeed() {

        return speed;
    }
    public void setSpeed(double speed) {

        this.speed = speed;
    }

    //toString

    public String toString() {
        if (mass == 0) {
            return "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f", speed) + ".";
        }
        else {
            return "I’m a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
        }
    }

    //grow
    public void grow(int addedMass) {
        mass += addedMass;
        double tempMass = mass;
        while (addedMass > 0) {
            if (tempMass <= 20) {
                speed++;
                addedMass--;
                tempMass--;
            }
            else if (tempMass > 20) {
                speed -= 0.5;
                addedMass--;
                tempMass--;
            }
        }

    }
    //defines True or False
    public boolean isDead() {
        if (mass == 0) {
            return true;
        } else {
            return false;
        }
    }
}
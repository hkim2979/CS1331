public class Frog {

    //Variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    //Constructors
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if (this.age > 1 && this.age < 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {

        this(name, (int)(ageInYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, 5, 5);
    }

    //Methods
    public void grow(int months) {
        age += months; //5 + 8     speed 5
        double tempMonth = age;

        while (months > 0) {
            if (tempMonth <= 12) {
                tongueSpeed ++;
            }
            else if (tempMonth > 30) {
                tongueSpeed--;
                if (tongueSpeed < 5) {
                    tongueSpeed = 5;
                }
            }
            tempMonth--;
            months--;
        }
        if (age >= 1 && age <= 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }

    public void grow() {
        grow(1);
    }

    public boolean eat(Fly fly) {
        if (!fly.isDead()) {
            if (tongueSpeed > fly.getSpeed()) {
                if (fly.getMass() >= 0.5 * age) {
                    grow();
                }
                fly.setMass(0);
                return true;
            }
            else {
                fly.grow(1);
                return false;
            }
        }
        return false;
    }

    public String toString() {
        if (isFroglet == true) {
            return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }
        return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    }

    //getter setter

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getTongueSpeed() {
        return tongueSpeed;
    }
    public void setTongueSpeed(double tongueSpeed) {
        this.tongueSpeed = tongueSpeed;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public boolean isFroglet() {
        return isFroglet;
    }
}
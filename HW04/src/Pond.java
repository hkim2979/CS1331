public class Pond {

    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog randomFrog = new Frog("randomFrog", 4.3, 6);

        Fly firstFly = new Fly(1, 3);
        Fly secondFly = new Fly(6);
        Fly thirdFly = new Fly(2, 4);

        peepo.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());

        peepo.eat(secondFly);
        System.out.println(secondFly.toString());

        peepo.grow(8);
        peepo.eat(secondFly);
        System.out.println(secondFly.toString());
        System.out.println(peepo.toString());
        System.out.println(randomFrog.toString());

        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}

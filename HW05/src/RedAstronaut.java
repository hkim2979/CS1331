import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {

    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }

    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Arrays.sort(super.getPlayers());
            int endIndex = super.getPlayers().length - 1;

            int topSusIndex = 0;

            for (int index = endIndex; index >= 0; index--) {
                Player player = (Player) super.getPlayers()[index];
                if (!player.isFrozen() && !super.equals(player)) {
                    topSusIndex = index;
                    break;
                }
            }

            Player topPlayer = (Player) (super.getPlayers()[topSusIndex]);

            if (topSusIndex != 0) {
                Player secondTop = super.getPlayers()[topSusIndex-1];

                if (topPlayer.compareTo(secondTop) != 0) {
                    topPlayer.setFrozen(true);
                }
            }
            else {
                topPlayer.setFrozen(true);
            }
        }

        super.gameOver();
    }

    public void freeze(Player p) {
        if (!(p instanceof Impostor) && !p.isFrozen()) {
            if (this.getSusLevel() < p.getSusLevel()) {
                p.setFrozen(true);
            }
            else {
                this.setSusLevel(2 * this.getSusLevel());
            }

            if (super.gameOver()) {

            }
        }
    }

    public void sabotage(Player p) {
        if (!(p instanceof Impostor) && !this.isFrozen() && !p.isFrozen()) {
            if (this.getSusLevel() < 20) {
                p.setSusLevel((int)(1.5 * p.getSusLevel()));
            }
            else {
                p.setSusLevel((int)(1.25 * p.getSusLevel()));
            }
        }
    }

    public boolean equals(Object o) {

        if (o instanceof RedAstronaut) {
            RedAstronaut other = (RedAstronaut) o;
            boolean condition = (this.getSkill() == other.getSkill());

            return super.equals(o) && condition;
        }

        return false;
    }

    public String toString() {
        String playerStr = super.toString()
                + " I am an " + this.skill + " player!";
        if (this.getSusLevel() > 15) {
            playerStr = playerStr.toUpperCase();
        }
        return playerStr;
    }

    public void setSkill(String skill) {
        this.skill = skill.toLowerCase();
    }

    public String getSkill() {
        return this.skill;
    }
}
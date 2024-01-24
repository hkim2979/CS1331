import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Arrays.sort(RedAstronaut.getPlayers());
            int endIndex = RedAstronaut.getPlayers().length - 1;

            int topSusIndex = 0;

            for (int index = endIndex; index >= 0; index--) {
                Player player = (Player) super.getPlayers()[index];
                if (!player.isFrozen()) {
                    topSusIndex = index;
                    break;
                }
            }

            Player topSusPlayer = (Player) (super.getPlayers()[topSusIndex]);

            if (topSusIndex != 0) {
                Player secondHighestSusPlayer = super.getPlayers()[topSusIndex-1];

                if (topSusPlayer.compareTo(secondHighestSusPlayer) != 0) {
                    topSusPlayer.setFrozen(true);
                }
            }
            else {
                topSusPlayer.setFrozen(true);
            }

            super.gameOver();
        }
    }

    public void completeTask() {
        if (!this.isFrozen() && this.numTasks > 0) {
            int reducedValue = (this.taskSpeed > 20 ? 2 : 1);
            this.numTasks = this.numTasks - reducedValue;
            this.numTasks = (this.numTasks < 0 ? 0 : this.numTasks);

            if (this.numTasks == 0) {
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int)(0.5 * this.getSusLevel()));
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut others = (BlueAstronaut) o;
            boolean first = (this.numTasks == others.numTasks);
            boolean second = (this.taskSpeed == others.taskSpeed);

            return super.equals(o) && first && second;
        }

        return false;
    }

    public String toString() {
        String playerStr = super.toString()
                + " I have " + this.numTasks + " leftover.";
        if (this.getSusLevel() > 15) {
            playerStr = playerStr.toUpperCase();
        }

        return playerStr;
    }

    public int getNumTasks() {
        return this.numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return this.taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
}
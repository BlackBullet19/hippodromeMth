package hippodrome;

public abstract class Participant implements Runnable {

    private String name;
    private double speed;
    private double age;
    private int startingPosition;
    private double distanceDone;
    private boolean isFinished;

    public Participant(String name, double speed, double age) {
        this.name = name;
        this.speed = speed;
        this.age = age;
        this.isFinished = false;
    }

    @Override
    public void run() {
        while (!isFinished) {
            makeStep();
        }
    }

    private void makeStep() {
        distanceDone += actualSpeed();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDistanceDone(double distanceDone) {
        this.distanceDone = distanceDone;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    public double getDistanceDone() {
        return distanceDone;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    private double actualSpeed() {
        return (age <= 5 ? speed - Math.random() : speed - (age / 10)) + Math.random() * 2;
    }

    protected void setFinished() {
        isFinished = true;
    }

    @Override
    public String toString() {
        return name + "; Starting position " + startingPosition + "; Distance done " + distanceDone;
    }
}

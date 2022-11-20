package hippodrome;

import java.util.List;

public class Race implements Runnable {

    private Circle circle;

    private List<Participant> participantList;

    private int positionIndex;


    public Race(Circle circle, List<Participant> participantList) {

        this.circle = circle;
        this.participantList = participantList;
        this.positionIndex = 1;
    }

    @Override
    public void run() {

        participantList.forEach(this::setStartPosition);
        for (Participant participant : participantList) {
            new Thread(participant).start();
        }
        while (!checkWinner()) {
            checkWinner();
        }
        raceEnd();
    }

    public boolean checkWinner() {
        for (Participant participant : participantList) {
            if (participant.getDistanceDone() >= circle.getRaceLength()) {
                participant.setFinished();
                System.out.println("Winner : " + participant);
                return true;
            }
        }
        return false;
    }

    public void setStartPosition(Participant participant) {
        participant.setStartingPosition(positionIndex++);
    }

    public void raceEnd(){
        participantList.forEach(Participant::setFinished);
    }
}

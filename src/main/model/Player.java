package model;

public class Player {
    public class Difficulty {
        private String diff;
        private int highScore;

        public Difficulty(String diff,int highScore) {
            this.diff = diff;
            this.highScore = highScore;
        }
    }

    private Difficulty easyMode;
    private Difficulty moderateMode;
    private Difficulty hardMode;

    public Player(Difficulty easyMode,Difficulty moderateMode,Difficulty hardMode) {
        this.easyMode = easyMode;
        this.moderateMode = moderateMode;
        this.hardMode = hardMode;
    }

    public void init() {
        easyMode = new Difficulty("easy",0);
        moderateMode = new Difficulty("moderate",0);
        hardMode = new Difficulty("hard",0);
    }
}

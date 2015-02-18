public class PicomonGame {

    public enum Player {
        GYM_LEADER("Gym leader"), TRAINER("Trainer");
        
        private String representation;
        private Player(String representation) {
            this.representation = representation;
        }

        @Override
        public String toString() {
            return representation;
        }
    }

    public class Round {
        public Player winner; // null if tied.
        public PicomonCard gymLeaderCard;
        public PicomonCard trainerCard;
        
        public Round(PicomonCard gymLeaderCard, PicomonCard trainerCard) {
            this.gymLeaderCard = gymLeaderCard;
            this.trainerCard = trainerCard;
        }

        @Override
        public String toString() {
            if (winner == null) {
                return "It's a tie between " + Player.GYM_LEADER + "'s " + gymLeaderCard + " and " +
                        Player.TRAINER + "'s " + trainerCard + "!";
            } else {
                Player loser = winner == Player.GYM_LEADER ? Player.TRAINER : Player.GYM_LEADER;
                PicomonCard winningCard = winner == Player.GYM_LEADER ? gymLeaderCard : trainerCard;
                PicomonCard losingCard = winner == Player.GYM_LEADER ? trainerCard : gymLeaderCard;
                return winner + "'s " + winningCard + " beats " + loser + "'s " + losingCard + "!";
            }
        }
    }

    private PicomonDeck gymLeaderDeck;
    private PicomonDeck trainerDeck;
    private int gymLeaderPosition;
    private int trainerPosition;
    
    public PicomonGame() {
        this(new PicomonDeck(), new PicomonDeck());
    }
    
    public PicomonGame(PicomonDeck gymLeaderDeck, PicomonDeck trainerDeck) {
        if (gymLeaderDeck.getSize() != trainerDeck.getSize()) {
            throw new IllegalArgumentException();
        }

        gymLeaderPosition = 0;
        trainerPosition = 0;
        this.gymLeaderDeck = gymLeaderDeck;
        this.trainerDeck = trainerDeck;
    }
    
    public PicomonDeck getGymLeaderDeck() {
        return gymLeaderDeck;
    }
    
    public PicomonDeck getTrainerDeck() {
        return trainerDeck;
    }

    public boolean isMatchOver() {
         return this.gymLeaderPosition >= this.gymLeaderDeck.getSize() || this.trainerPosition >= this.trainerDeck.getSize();
    }
    
    public Player getLeader() {
        // Implement me!
        if(this.gymLeaderPosition < this.trainerPosition){
            return Player.GYM_LEADER;
        } else if(this.trainerPosition < this.gymLeaderPosition){
            return Player.TRAINER;
        } 
        return null;
    }
    
    public Round playRound() {
        // Implement me!
        Round round = new Round(this.gymLeaderDeck.cardAt(gymLeaderPosition), this.trainerDeck.cardAt(trainerPosition));

        if(round.gymLeaderCard.beats(round.trainerCard)){
            round.winner = Player.GYM_LEADER;
            this.trainerPosition++;
            round.trainerCard = this.trainerDeck.cardAt(this.trainerPosition);
        } else if(round.trainerCard.beats(round.gymLeaderCard)) {
            round.winner = Player.TRAINER;
            this.gymLeaderPosition++;
            round.gymLeaderCard = this.gymLeaderDeck.cardAt(this.gymLeaderPosition);
        } else {
            round.winner = null;
        }

        return round;
    }

    public Round[] playMatch() {
        // Implement me!
        Round[] rounds = new Round[this.trainerDeck.getSize() * 2];//rounds.length == maximum number of rounds that could be played

        int index = 0;
        while(!isMatchOver()){
            rounds[index] = this.playRound();
            index++;
        }

        return rounds;
    }

    public static void main(String[] args) {
        // Implement me!
        try{
            if(args.length == 0){

            } else if(args.length > 0 && args.length % 2 == 0) {

            } 

        }
        
        catch(Exception e) {
            System.out.println("Cannot create a deck based on the supplied arguments.");
            return;
        }
    }

}

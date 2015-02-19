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
            
        } else if(round.trainerCard.beats(round.gymLeaderCard)) {
            round.winner = Player.TRAINER;
            this.gymLeaderPosition++;
        } else {
            round.winner = null;
            this.trainerPosition++;
            this.gymLeaderPosition++;
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
                //run random deck code
                System.out.println("Creating random decks...");

                PicomonDeck deck1 = new PicomonDeck();
                PicomonDeck deck2 = new PicomonDeck();

                System.out.println("Gym Leader's deck: " + deck1 + "\n\n" + "Trainer's deck: " + deck2);

                PicomonGame game = new PicomonGame(deck1, deck2);

                Round[] rounds = game.playMatch();

                for(Round r: rounds){
                    if(r == null){
                        System.out.println("And the winner is: " + game.getLeader() + "!");
                        break;
                    }
                    System.out.println(r);
                }


            } else if(args.length > 0 && args.length % 2 == 0) {
                //run whatever arguments they put in <element> <power>
                System.out.println("Creating decks...");

                int[] powers = new int[args.length/2];
                int index = 0;

                for(int i = 1; i < args.length; i+=2){
                    powers[index] = Integer.parseInt(args[i]);
                    index++;
                }

                PicomonElement[] elements = new PicomonElement[args.length/2];
                index = 0;
                
                for(int i = 0; i < args.length; i+=2){
                    elements[index] = PicomonElement.valueOf(args[i].toUpperCase());
                    index++;
                }

                PicomonCard[] deck = new PicomonCard[args.length/2];
                for(int i = 0; i < deck.length; i++){
                    deck[i] = new PicomonCard(elements[i], powers[i]);
                }

                PicomonDeck deck1 = new PicomonDeck(deck);
                PicomonDeck deck2 = new PicomonDeck(deck);

                int random = (int) (Math.random() * 100);//shuffle the decks a random number of times
                for(int i = 0; i < random; i++){
                    deck1.shuffle();
                }
                random = (int) (Math.random() * 100);
                for(int i = 0; i < random; i++){
                    deck2.shuffle();
                }

                System.out.println("Gym Leader's deck: " + deck1 + "\n\n" + "Trainer's deck: " + deck2);

                PicomonGame game = new PicomonGame(deck1, deck2);

                Round[] rounds = game.playMatch();

                for(Round r: rounds){
                    if(r == null){
                        System.out.println("And the winner is: " + game.getLeader() + "!");
                        break;
                    }
                    System.out.println(r);
                }
                
            } else{
                throw new Exception();
            }
        }
        
        catch(Exception e) {
            System.out.println("Cannot create a deck based on the supplied arguments.");
            return;
        }
    }

}

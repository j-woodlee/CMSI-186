import java.util.HashMap;
import java.util.Map;

public class PicomonDeck {

    private PicomonCard[] cards;
    
    public PicomonDeck() {
        // Note how the default deck thus has 10 cards.
        this(new PicomonCard[] {
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard()
        });
    }

    public PicomonDeck(PicomonCard... cards) {
        this.cards = cards;     
    }

    public PicomonCard cardAt(int index) {
        if (index < 0 || index > cards.length - 1) {
            throw new IllegalArgumentException();
        } else {
            return cards[index];
        }
    }

    public int getSize() {
        return cards.length;
    }

    public void shuffle() {
        // Implement me!

        PicomonCard[] result = new PicomonCard[this.cards.length];

        if(this.cards.length % 2 == 0){

            PicomonCard[] firstHalf = new PicomonCard[this.cards.length/2];
            PicomonCard[] secondHalf = new PicomonCard[this.cards.length/2];

            for(int i = 0; i < firstHalf.length; i++){
                firstHalf[i] = this.cards[i];
            }

            int index = 0;
            for(int i = firstHalf.length; i < cards.length; i++){
                secondHalf[index] = this.cards[i];
                index++;
            }


            index = 0;
            for(int i = 0; i < cards.length; i+=2){
                result[i] = firstHalf[index];
                index++;
            }

            index = 0;

            for(int i = 1; i < cards.length; i+=2){
                result[i] = secondHalf[index];
                index++;
            }

        }


        else{

            PicomonCard[] firstHalf = new PicomonCard[(this.cards.length/2) + 1];//first half is longer if odd
            PicomonCard[] secondHalf = new PicomonCard[this.cards.length/2];

            for(int i = 0; i < firstHalf.length; i++){
                firstHalf[i] = this.cards[i];
            }

            int index = 0;

            for(int i = firstHalf.length; i < cards.length; i++){
                secondHalf[index] = this.cards[i];
                index++;
            }


            index = 0;
            for(int i = 0; i < cards.length; i+=2){
                result[i] = firstHalf[index];
                index++;
            }

            index = 0;

            for(int i = 1; i < cards.length;i+=2){
                result[i] = secondHalf[index];
                index++;
            }
        }

        this.cards = result;
        
    }

    public boolean orderedEquals(PicomonDeck other) {
        // Implement me!

        boolean sameOrder = false;

        int count = 0;

        if(this.cards.length != other.cards.length){
            return false;
        }

        for(int i = 0; i < this.cards.length; i++){
            if(this.cards[i].equals(other.cards[i])){
                count++;
            }
        }

        if(count == this.cards.length){
            sameOrder = true;
        }
        
        return this.equals(other) && sameOrder;

    }



    @Override
    public String toString() {
        String result = "[\n";
        for (PicomonCard card: cards) {
            result += "    ";
            result += card;
            result += "\n";
        }
        return result + "]";
    }

    // Advanced Java---study with caution.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        PicomonDeck other = (PicomonDeck)obj;
        // Due to the possibility of duplicates, deck comparison is a notch trickier.
        // Our approach is to count the cards in each deck then ensure that the cards
        // and counts are the same.
        return tally().equals(other.tally());
    }

    private Map<PicomonCard, Integer> tally() {
        Map<PicomonCard, Integer> result = new HashMap<PicomonCard, Integer>();
        for (PicomonCard card: cards) {
            Integer value = result.get(card);
            if (value == null) {
                result.put(card, 1);
            } else {
                result.put(card, value + 1);
            }
        }
        
        return result;
    }
}

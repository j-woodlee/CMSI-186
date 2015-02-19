import java.util.HashMap;
import java.util.Map;

public class PicomonCard {

    private String name;
    private PicomonElement element;
    private int power;
    
    public PicomonCard() {
        this(getRandomElement(), getRandomPower());
    }

    public PicomonCard(PicomonElement element, int power) {
        this(getRandomName(element), element, power);
    }
    
    public PicomonCard(String name, PicomonElement element, int power) {
        if (power < 1) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.element = element;
        this.power = power;
    }
    
    public String getName() {
        return name;
    }

    public PicomonElement getElement() {
        return element;
    }
    
    public int getPower() {
        return power;
    }

    public boolean beats(PicomonCard opponent) {
        // Implement me

        if(this.element == opponent.element){
            return this.power > opponent.power;
        }

        if(this.power == opponent.getPower() && this.element == opponent.getElement()){
            return false;
        }
       
        if ((this.element == PicomonElement.FIRE) && (opponent.getElement() == PicomonElement.AIR)) {
            return this.power * 3 > opponent.getPower();
        } else if(opponent.getElement() == PicomonElement.FIRE && this.element == PicomonElement.AIR){
            return this.power > opponent.getPower() * 3;
        }

        if((this.element == PicomonElement.AIR) && ((opponent.getElement() == PicomonElement.WATER) || (opponent.getElement() == PicomonElement.EARTH))){
            return this.power * 2 > opponent.getPower();
        } else if(opponent.getElement() == PicomonElement.AIR && ((this.element == PicomonElement.WATER) || (this.element == PicomonElement.EARTH)) ){
            return this.power > opponent.power * 2;
        }

        if((this.element == PicomonElement.WATER) && ((opponent.getElement() == PicomonElement.FIRE) || (opponent.getElement() == PicomonElement.EARTH))){       
            return this.power * 2 > opponent.getPower();
        } else if(opponent.element == PicomonElement.WATER && ((this.element == PicomonElement.FIRE) || (this.element == PicomonElement.EARTH))){
            return this.power > opponent.getPower() * 2;
        }

        if((this.element == PicomonElement.EARTH) && (opponent.getElement() == PicomonElement.FIRE)){
            return this.power * 4 > opponent.getPower();
        }
        else if(opponent.element == PicomonElement.EARTH && this.element == PicomonElement.FIRE){
            return this.power > opponent.power * 4;
        }

        return this.power > opponent.power;

    }

    @Override
    public String toString() {
        return name + " (" + element + ", " + power + ")";
    }

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

        PicomonCard other = (PicomonCard)obj;
        if ((this.element != other.element) || (this.power != other.power)) {
            return false;
        }

        // name can be null, so extra handling is needed.
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        return true;
    }
    
    // Advanced Java---look away, look away!
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + power;
        return result;
    }

    private static final Map<PicomonElement, String[]> NAMES = new HashMap<PicomonElement, String[]>();
    static {
        NAMES.put(PicomonElement.FIRE, new String[] {
            "Justin", "Anthony", "Christopher", "Jake", "Francis",
            "Andres", "Perry", "Caitlin", "Joseph"
        });
        
        NAMES.put(PicomonElement.EARTH, new String[] {
            "Claire", "Jacqueline", "Matthew", "Jared", "Ryan",
            "Noah", "Brent", "Ian", "Huayang"
        });
        
        NAMES.put(PicomonElement.WATER, new String[] {
            "Mary", "Sasha", "Zach", "Victor", "Anna",
            "Evan", "Isabella", "Ruben", "Filip"
        });
        
        NAMES.put(PicomonElement.AIR,  new String[] {
            "Savannah", "Carleen", "Sean", "Mathew", "Josh",
            "Mackenzie", "Jake", "Jordan"
        });
    }

    private static String getRandomName(PicomonElement element) {
        String[] elementNames = NAMES.get(element);
        return elementNames[(int)Math.floor(Math.random() * elementNames.length)];
    }
    
    private static PicomonElement getRandomElement() {
        return PicomonElement.values()[(int)Math.floor(Math.random() * 4)];
    }

    private static int getRandomPower() {
        return (int)((Math.random() * 99) + 1);
    }

}

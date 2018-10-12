

package exercise_202;

/**
 * @author Kilian Stöckler
 */
public class Sender {

    
    private String name;
    private double frequenz;
    private Band band;
    enum Band{
        AM,FM;
    }

    public Sender(String name, double frequenz, Band band) {
        this.name = name;
        this.frequenz = frequenz;
        this.band = band;
    }

    public Band getBand() {
        return band;
    }

    public double getFrequenz() {
        return frequenz;
    }

    public String getName() {
        return name;
    }

    
    
    
}

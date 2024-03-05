package src;

public class Wuerfel {
    int seiten;
    public Wuerfel(int pSeiten){
        seiten=pSeiten;
    }
    public int wuerfeln(){
        int maximum = seiten;
        int minimum = 1;
        int spanne = maximum - minimum + 1;



            int zahl = (int)(Math.random() * spanne) + minimum;
        return zahl;
    }
    public int gibSeiten(){
        return seiten;
    }
}

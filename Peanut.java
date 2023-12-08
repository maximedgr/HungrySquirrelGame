/**
 *
 * @author Maxime D.
 * Final Project JAVA I - UCLA
 */
public class Peanut extends Nut {
    public static final int NUTRITION_POINTS = 10;
    
    /**
     * Method. Constructor
     * @param row, an int
     * @param col, an int
     * */
    public Peanut(int row, int col){
        super('P',row,col,"Almond");
        this.name="Peanut";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    /**
     * Method. Constructor
     * */
    public Peanut(){
        super('P',0,0,"Almond"); //// Temporary position
        this.name="Peanut";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

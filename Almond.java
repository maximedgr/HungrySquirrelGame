/**
 *
 * @author Maxime D.
 * Final Project JAVA I - UCLA
 */
public class Almond extends Nut {
    public static final int NUTRITION_POINTS = 5;
    
    /**
     * Method. Constructor
     * @param row, an int
     * @param col, an int
     * */
    public Almond(int row, int col){
        super('A',row,col,"Almond");
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    /**
     * Method. Constructor
     * */
    public Almond(){
        super('A',0,0,"Almond"); // Temporary position
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

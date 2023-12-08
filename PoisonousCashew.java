/**
 *
 * @author Maxime D.
 * Final Project JAVA I - UCLA
 */
public class PoisonousCashew extends Nut {
    public static final int NUTRITION_POINTS = -15;
    
    /**
     * Method. Constructor
     * @param row, an int
     * @param col, an int
     * */
    public PoisonousCashew(int row, int col){
        super('X',row,col,"Almond");
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    /**
     * Method. Constructor
    **/
    public PoisonousCashew(){
        super('X',0,0,"Almond"); // Temporary position
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

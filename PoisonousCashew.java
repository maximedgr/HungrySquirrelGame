/**
 *
 * @author Maxime D.
 */
public class PoisonousCashew extends Nut {
    public static final int NUTRITION_POINTS = -15;
    
    public PoisonousCashew(int row, int col){
        super('X',row,col,"Almond");
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    public PoisonousCashew(){
        super('X',0,0,"Almond"); // Temporary position
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

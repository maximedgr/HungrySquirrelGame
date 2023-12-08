/**
 *
 * @author Maxime D.
 */
public class Almond extends Nut {
    public static final int NUTRITION_POINTS = 5;
    
    public Almond(int row, int col){
        super('A',row,col,"Almond");
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    public Almond(){
        super('A',0,0,"Almond"); // Temporary position
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

/**
 *
 * @author Maxime D.
 */
public class Peanut extends Nut {
    protected final int NUTRITION_POINTS = 10;
    
    public Peanut(int row, int col){
        super('P',row,col,"Almond");
        this.name="Peanut";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    public Peanut(){
        super('P',0,0,"Almond"); //// Temporary position
        this.name="Peanut";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

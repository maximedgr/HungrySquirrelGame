/**
 *
 * @author Maxime D.
 */
public class Almond extends Nut {
    protected final int NUTRITION_POINTS = 5;
    
    public Almond(int row, int col){
        super('A',row,col,"Almond");
        this.name="Almond";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
    public Almond(){
        super('A',0,0,"Almond"); // Temporary position
        this.name="Almond";
        this.nutritionPoints=NUTRITION_POINTS;
    }
    
}

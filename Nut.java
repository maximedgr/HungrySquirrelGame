/**
 *
 * @author Maxime D.
 */
import java.util.Random;

public abstract class Nut extends Entity {
    
    public static final int TOTAL_NUTS=5;
    public static final int TOTAL_POISONOUS_NUTS=5;
    protected int nutritionPoints;
    protected String name;
    
    
    public Nut(char symbol, int row, int col, String name){
        super(symbol,row,col);
        this.name=name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String value){
        this.name=value;
    }
    
    
    public int getNutritionPoints(){
        return this.nutritionPoints;
    } 
    
    public void setNutritionPoints(int value){
       this.nutritionPoints=value;
    }
    
    @Override
    public void create() {
        Random random = new Random();
        int row, col;

        while (true) {
            row = random.nextInt(Maze.HEIGHT);
            col = random.nextInt(Maze.WIDTH);

            // Check if the generated position is available (not a wall, squirrel, or another nut)
            if (Maze.available(row, col)) {
                put(row, col);
                break;
            }
        }
    }
}

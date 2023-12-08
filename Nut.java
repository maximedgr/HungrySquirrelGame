/**
 *
 * @author Maxime D.
 * Final Project - JAVA I - UCLA
 */
import java.util.Random;

public abstract class Nut extends Entity {
    public static final int TOTAL_NUTS=5;
    public static final int TOTAL_POISONOUS_NUTS=5;
    protected int nutritionPoints;
    protected String name;
    
    /**
    * Method. Nut Constructor
    * @param symbol, represents nut's symbol
    * @param row
    * @pram col
    **/
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
    
    /**
    * Method. Create an Nut and put it in the maze at a random available position
    **/
    @Override
    public void create() {
        Random random = new Random();
        int row, col;

        while (true) {
            row = random.nextInt(Maze.HEIGHT);
            col = random.nextInt(Maze.WIDTH);

            // Check if the generated position is available (not a wall, squirrel, or another nut)
            if (Maze.available(row, col)) {
                Entity e = put(row, col);
                // Juste in case with randomly put a Nut on another nut
                if(e instanceof Nut){
                    e.create();
                }
                // If Squirrel was at a nut position, change desired Squirrel position for a random one
                if(e instanceof Squirrel){
                    e.create();
                }
                break;
            }
        }
    }
}

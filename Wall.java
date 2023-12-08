/**
 *
 * @author Maxime D.
 * Final Project - JAVA I - UCLA
 */
public class Wall extends Entity {
    
    /**
    * Method. Wall Constructor
    * @param row
    * @pram col
    **/
    public Wall(int row, int col){
        super('*',row,col);
    }
    
    /**
    * Method. Wall Constructor
    **/
    @Override
    public void create() {
        // Implementation for creating a squirrel, if needed
    }
    
}

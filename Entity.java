/**
 *
 * @author Maxime D.
 * Final Project - JAVA I - UCLA
 */
public abstract class Entity {
    protected char symbol;
    protected int row;
    protected int col;
    
     /**
     * Method. Constructor
     * @param symbol, a char thant represents entity symbol
     * @param row, an int
     * @param col, an int
     * */
    public Entity(char symbol, int row, int col) {
        this.symbol = symbol;
        this.row = row;
        this.col = col;
    }
    
     /**
     * Method. Abstract method to creat entities
     * */
    public abstract void create();

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    /**
     * Method. put method, insert an entity in the maze
     * @param row, an int
     * @param col, an int
     * */
    public Entity put(int row, int col) {
        Entity prev_Entity = Maze.getMaze()[row][col];
        Maze.setMaze(this.row,this.col,null); // Delete previous position
        this.col=col;
        this.row=row;
        Maze.setMaze(row,col,this);
        if(prev_Entity!=null){
            // Temporary set position for previous entity at -1;-1
            prev_Entity.col=-1;
            prev_Entity.col=-1;

        }
        return prev_Entity;
    }
    
    /**
     * Method. toString override to return only entity symbol
     * */
    @Override 
    public String toString(){
        return symbol+"";
    }
}


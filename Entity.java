/**
 *
 * @author Maxime D.
 */
public abstract class Entity {
    protected char symbol;
    protected int row;
    protected int col;

    public Entity(char symbol, int row, int col) {
        this.symbol = symbol;
        this.row = row;
        this.col = col;
    }
    
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

    public Entity put(int row, int col) {
        this.col=col;
        this.row=row;
        Entity prev_Entity = Maze.getMaze()[row][col];
        Maze.setMaze(row,col,this);
        if(prev_Entity!=null){
            prev_Entity.col=-1;
            prev_Entity.col=-1;

        }
        return prev_Entity;
    }
    
    @Override 
    public String toString(){
        return symbol+"";
    }
}


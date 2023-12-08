/**
 *
 * @author Maxime D.
 */
import java.util.Scanner;

public class Squirrel extends Entity implements Movable {
    
    protected int pointsCollected;
    protected int totalNutsEaten;
    
    public Squirrel(int row, int col){
        super('@',row,col);
        this.pointsCollected=0;
        this.totalNutsEaten=0;
    }
    
    public Squirrel(){
        super('@',0,0);
        this.pointsCollected=0;
        this.totalNutsEaten=0;
    }
    
    public int getPointsCollected(){
        return this.pointsCollected;
    }
    
    public void setPointsCollected(int value){
        this.pointsCollected=value;
    }
    
    public int getTotalNutsEaten(){
        return this.totalNutsEaten;
    }
    
    public void setTotalNutsEaten(int value){
        this.totalNutsEaten=value;
    }
    
    @Override
    public void move(char direction) {
        int newRow = this.row;
        int newCol = this.col;

        switch(direction) {
            case 'U': // Move up
                newRow -= 1;
                break;
            case 'D': // Move down
                newRow += 1;
                break;
            case 'L': // Move left
                newCol -= 1;
                break;
            case 'R': // Move right
                newCol += 1;
                break;
        }

        // Check if the new position is within the maze and not a wall
        if (Maze.available(newRow, newCol)) {
            Entity prev = this.put(newRow, newCol);
            this.col=newCol;
            this.row=newRow;
            
            //do some thing with prev entity
        }
    }
    
    @Override
    public void create() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.print("Enter row for squirrel (0-19): ");
            row = scanner.nextInt();
            System.out.print("Enter column for squirrel (0-49): ");
            col = scanner.nextInt();

            // Validate the input location
            if (row >= 0 && row < Maze.HEIGHT && col >= 0 && col < Maze.WIDTH && Maze.available(row, col)) {
                Entity prev_entity = this.put(row, col); // Set the position if valid
                break;
            } else {
                System.out.println("Invalid or unavailable location. Please enter a new location.");
            }
        }
    }
}

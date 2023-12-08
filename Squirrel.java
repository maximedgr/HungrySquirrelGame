/**
 *
 * @author Maxime D.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Squirrel extends Entity implements Movable {
    
    protected int pointsCollected;
    protected int totalNutsEaten;
    protected int totalPoisonousCashewEaten;
    
    public Squirrel(int row, int col){
        super('@',row,col);
        this.pointsCollected=0;
        this.totalNutsEaten=0;
        this.totalPoisonousCashewEaten=0;
    }
    
    public Squirrel(){
        super('@',0,0);
        this.pointsCollected=0;
        this.totalNutsEaten=0;
        this.totalPoisonousCashewEaten=0;
    }
    
    public int getPointsCollected(){
        return this.pointsCollected;
    }
    
    @Override
    public void move(char direction) {
        int newRow = this.row;
        int newCol = this.col;

        switch(direction) {
            case 'u': // Move up
                newRow -= 1;
                break;
            case 'd': // Move down
                newRow += 1;
                break;
            case 'l': // Move left
                newCol -= 1;
                break;
            case 'r': // Move right
                newCol += 1;
                break;
        }

        // Check if the new position is within the maze and not a wall
        if (Maze.available(newRow, newCol)) {
            Entity prev = this.put(newRow, newCol);
            if(prev instanceof Almond){
                this.pointsCollected+=Almond.NUTRITION_POINTS;
                this.totalNutsEaten+=1;
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("!!! Squirrel ate Almond and gained 5 points"+" (Total "+ this.pointsCollected+ " points) !!!");
            }
            if(prev instanceof Peanut){
                this.pointsCollected+=Peanut.NUTRITION_POINTS;
                this.totalNutsEaten+=1;
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("!!! Squirrel ate Peanut and gained 10 points"+" (Total "+ this.pointsCollected+ " points) !!!");
            }
            if(prev instanceof PoisonousCashew){
                this.pointsCollected+=PoisonousCashew.NUTRITION_POINTS;
                this.totalPoisonousCashewEaten+=1;
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("!!! OUCH ! Squirrel ate Poisonous Cashew and lost 15 points"+" (Total "+ this.pointsCollected+ " points) !!!");
            }
        }
    }
    
    @Override
public void create() {
    Scanner scanner = new Scanner(System.in);
    int row = -1, col = -1;

    while (true) {
        try {
            System.out.print("Enter row for squirrel (0-"+Maze.HEIGHT+"): ");
            row = scanner.nextInt();
            System.out.print("Enter column for squirrel (0-"+Maze.WIDTH+"): ");
            col = scanner.nextInt();

            // Validate the input location
            if (row >= 0 && row < Maze.HEIGHT && col >= 0 && col < Maze.WIDTH && Maze.available(row, col)) {
                Entity prev_entity = this.put(row, col); // Set the position if valid
                break;
            } else {
                System.out.println("Invalid or unavailable location. Please enter a new location.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integer values.");
            scanner.next(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

}

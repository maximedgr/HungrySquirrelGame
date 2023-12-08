/**
 *
 * @author Maxime D.
 * Final Project - JAVA I - UCLA
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private static Entity[][] maze;
    public static final int HEIGHT = 20;
    public static final int WIDTH = 50;
    
    /**
    * Method. Maze Constructor
    **/
    public Maze() {
        maze = new Entity[HEIGHT][WIDTH];
    }
    
    /**
    * Method. Maze Constructor
    * @param file_name, a Sting thant represents maze's file
    * */
    public Maze(String file_name) {
        maze = new Entity[HEIGHT][WIDTH];
        create(file_name);
    }
    
    /**
    * Method. Return Maze tab
    * @return Entity[][]
    * */
    public static Entity[][] getMaze(){
        return maze;
    }
    /**
    * Method. setMaze, set an entity into the maze
    * @param row
    * @param col
    * @param e 
    * */
    public static void setMaze(int row,int col,Entity e){
        maze[row][col]=e;
    }
    
    /**
    * Method. Create / Initiate maze from file
    * @param file_name, a Sting thant represents maze's file
    * */
    private static void create(String file_name) {
        try {
            Scanner scanner = new Scanner(new File(file_name));
            for (int i = 0; i < HEIGHT; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    if(line.charAt(j)=='*'){
                        maze[i][j] = new Wall(i,j);
                    }
                    else{
                        maze[i][j] = null;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Method. check if a position in the maze is available (not a wall)
    * @return boolean
    * @param row
    * @param col
    * */
    public static boolean available(int row, int col) {
        // Check if the specified position is within the maze bounds
        if (row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH) {
            return !(maze[row][col] instanceof Wall);
        }
        return false; 
    }
    
    /**
    * Method. Display maze in the console
    * */
    public static void display() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(maze[i][j]==null){
                    System.out.print(" ");
                }
                else{
                   System.out.print(maze[i][j]); 
                }
            }
            System.out.println();
        }
    }
}


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String file_path = input.nextLine();
        File painting_file = new File(file_path);
        PaintingLoader load_paint = new PaintingLoader(painting_file);
        System.out.println( load_paint.generatePainting() );
    }
}

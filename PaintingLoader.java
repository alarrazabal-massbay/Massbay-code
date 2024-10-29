import java.io.*;
import java.util.Scanner;

public class PaintingLoader {
    //ATTRIBUTES
    File paint_file;

    //METHODS
    public PaintingLoader( File painting_file ) {
        this.paint_file = painting_file;
    }

    public String generatePainting() throws FileNotFoundException {
        boolean paint_exists = this.paint_file.exists();
        String file_path = this.paint_file.getName();
        file_path = file_path.substring(file_path.length() - 4, file_path.length());

        if (paint_exists == true && file_path.equals(".pnt")) {
            int rows = 0;
            int columns = 0;
            String[] paint_rows = new String[25];

            Scanner paint_reader = new Scanner(this.paint_file);
            while ( paint_reader.hasNext() ) {
                paint_rows[rows] = paint_reader.nextLine();
                if ( rows == 0 ) {
                    columns = paint_rows[rows].length();
                }
                rows++;
            }

            Painting my_painting = new Painting(rows, columns);

            for ( int rowNum=0; rowNum < rows; rowNum++) {
                String[] color_array = paint_rows[rowNum].split("");
                for ( int colNum=0; colNum < columns; colNum++) {
                    String color = convertToColor(color_array[colNum]);
                    my_painting.paintCell(rowNum, colNum, color);
                }
            }
            return "Success!";
        } else {
            return null;
        }
    }

    private String convertToColor(String color) {
        if (color.equals("R")) {
            return "red";
        } else if (color.equals("Y")) {
            return "yellow";
        } else if (color.equals("G")) {
            return "green";
        } else if (color.equals("C")) {
            return "cyan";
        } else if (color.equals("B")) {
            return "blue";
        } else if (color.equals("P")) {
            return "purple";
        } else if (color.equals("X")) {
            return "black";
        } else if (color.equals("O")) {
            return "white";
        } else {
            return " ";
        }
    }
}
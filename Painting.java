class Painting {
    //ATTRIBUTES
    private int height;
    private int width;
    private PaintingCell[][] grid;

    //METHODS
    public Painting( int rows, int columns ) {
        this.height = rows;
        this.width = columns;
        this.grid = new PaintingCell[this.height][this.width];
        for (int i=0; i < this.height; i++) {
            for (int j=0; j < this.width; j++) {
                this.grid[i][j] = new PaintingCell();
            }
        }
    }

    public boolean checkBoundaries( int row, int column ) {
        if ( ( 0 <= row && row <= this.height) && ( 0 <= column && column <= this.width ) ) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean paintCell( int row, int column, String color ) {
        if ( checkBoundaries(row, column) == true ) {
            PaintingCell cell = this.grid[row][column];
            cell.changeColor(color);
            cell.setVisibility(true);
            //When the cell is successfully edited, painting a cell returns 'true', otherwise it returns 'false'.
            return true;
        } else {
            return false;
        }
    }

    public boolean eraseCell( int row, int column, String color ) {
        if ( checkBoundaries(row, column) == true) {
            PaintingCell cell = this.grid[row][column];
            cell.setVisibility(false);
            //When the cell is successfully edited, panting a cell returns 'true', otherwise it returns 'false'
            return true;
        } else {
            return false;
        }
    }

    //DEBUGGING (EDIT LATER)
    public String toString() {
        String representation = "";

        for ( int row=0; row < this.height; row++) {
            for ( int column=0; column < this.width; column++) {
                representation = representation + this.grid[row][column];
            }
            representation = representation + "\n";
        }

        return representation;
    }
}
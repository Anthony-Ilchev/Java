public class MirrorFlipImage {
    //2d array method for the image itself 
    private static void displayImage(char[][] image) {
        for (char[] row : image) { //loop so we can loop through each row of the image
            for (char pixel : row) {
                System.out.print(pixel);
            }
            System.out.println();
        }
    }
    //method for horiontal image 
    private static char[][] horizontalMirror(char[][] image) {
        int rows = image.length; //loop through the rows of the image 
        int cols = image[0].length;
        char[][] flippedImage = new char[rows][cols];
        for (int i = 0; i < rows; i++) {  //creating another 2d array to store image 
            for (int j = 0; j < cols; j++) {
                flippedImage[i][j] = image[i][cols - 1 - j]; //flipping the image and mirroring it accross the vertical axis
            }
        }
        return flippedImage;
    }
    
    private static char[][] verticalMirror(char[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        char[][] flippedImage = new char[rows][cols]; //looping through the pixels
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {  //flipping the image and mirroring it horizontally 
                flippedImage[i][j] = image[rows - 1 - i][j];
            }
        }
        return flippedImage;
    }
    

          
    public static void main(String[] args) { //setting the 2d array image 
      char[][] image = {
            {'#', 'x', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', 'E', ' ', '#'},
            {'*', ' ', ' ', ' ', '|'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', 'y', '#'},
        }; 
        
        System.out.println("Original Image:"); //calling all the methods 
        displayImage(image);
        
        System.out.println("\nAfter Horizontal Mirror:");
        char[][] horizontalImageFlip = horizontalMirror(image);
        displayImage(horizontalImageFlip);
        
        System.out.println("\nAfter Vertical Mirror:");
        char[][] verticalImageFlip = verticalMirror(horizontalImageFlip);
        displayImage(verticalImageFlip);
    }
}

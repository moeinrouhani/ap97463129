package assignment7;

 public class shape {
    int radius;

    int side;

    int width;
    int length;


    boolean circle = false;
    boolean square = false;
    boolean rectangle = false;

    public void tostring(){
        if (circle == true)
            System.out.println ("circle " + "\t" + (radius*radius*3.14) + "\t" + (radius*2*3.14));


        if (square == true)
            System.out.println ("square" + "\t" + (side*side) + "\t" + (side*4));

        if (rectangle == true)
            System.out.println ("rectangle" + "\t" + (width*length) + "\t" + ((width+length)*2) );
    }
}

abstract class calculate{
    public void area(){};
}

class rectangle{
    double length, breadth;
    rectangle(double l,double b){
        length=l;
        breadth=b;
    }
    public void area(){
        System.out.println("Area of rectangle is " + length*breadth); 
    }
}

class square{
    double side;
    square(double s){
        side = s;
    }

    public void area(){
        System.out.println("Area of square is " + side*side);
    }
}

class triangle{
    double base, height;
    triangle(double b,double h){
        base=b;
        height=h;
    }
    public void area(){
        System.out.println("Area of triangle is " + 0.5*base*height);
    }
}

class circle{
    double radius;
    circle(double r){
        radius = r;
    }

    public void area(){
        System.out.println("Area of circle is " + 3.14*radius*radius);
    }
}

public class AbstractClass {
    public static void main(String [] args){
        rectangle r = new rectangle(10,15);
        square s = new square(5);
        triangle t = new triangle(5,10);
        circle c = new circle(5);
        r.area();
        s.area();
        t.area();
        c.area();
        
    }
}

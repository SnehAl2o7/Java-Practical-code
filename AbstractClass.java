abstract class calculate{
    public void area(rectangle r){
        System.out.println("Area of rectangle is " + r.length*r.breadth); 
    }

    public void area(triangle t){
        System.out.println("Area of triangle is " + 0.5*t.base*t.height);
    }

    public void area(circle c){
        System.out.println("Area of circle is " + 3.14*c.radius*c.radius);
    }

    public void area(square e){
        System.out.println("Area of square is " + e.side*e.side);
    }
}

class rectangle{
    double length, breadth;
    rectangle(double l,double b){
        length=l;
        breadth=b;
    }
}

class square{
    double side;
    square(double s){
        side = s;
    }
}

class triangle{
    double base, height;
    triangle(double b,double h){
        base=b;
        height=h;
    }
}

class circle{
    double radius;
    circle(double r){
        radius = r;
    }
}

public class AbstractClass {
    public static void main(String [] args){
        rectangle r = new rectangle(10,15);
        square s = new square(5);
        triangle t = new triangle(5,10);
        circle c = new circle(5);
        calculate cal = new calculate() {};
        cal.area(s);
        cal.area(c);
        cal.area(r);
        cal.area(t);
        
    }
}

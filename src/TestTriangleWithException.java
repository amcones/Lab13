public class TestTriangleWithException {
    public static void main(String[] args){
        try {
            TriangleWithException t1 = new TriangleWithException(1.5, 2, 3);
            System.out.println("Perimeter for t1: " + t1.getPerimeter());
            System.out.println("Area for t1: " + t1.getArea());

            TriangleWithException t2 = new TriangleWithException(1, 2, 3);
            System.out.println("Perimeter for t2: " + t2.getPerimeter());
            System.out.println("Area for t2: " + t2.getArea());
        }
        catch (IllegalTriangleException ex) {
            System.out.println("Illegal triangle");
            System.out.println("Side1: " + ex.getSide1());
            System.out.println("Side2: " + ex.getSide2());
            System.out.println("Side3: " + ex.getSide3());
        }
    }
}
class IllegalTriangleException extends Exception
{
    double side1,side2,side3;
    public IllegalTriangleException(double s1,double s2,double s3)
    {
        side1=s1;
        side2=s2;
        side3=s3;
    }
    public double getSide1()
    {
        return side1;
    }
    public double getSide2()
    {
        return side2;
    }
    public double getSide3()
    {
        return side3;
    }
}
class TriangleWithException {
    private double sideA;
    private double sideB;
    private double sideC;
    public TriangleWithException()
    {
        sideA=0;
        sideB=0;
        sideC=0;
    }
    public TriangleWithException(double s1,double s2,double s3) throws IllegalTriangleException
    {
        sideA=s1;
        sideB=s2;
        sideC=s3;
        setABC(s1,s2,s3);
    }
    public double getA(){  	return sideA; 	}
    public double getB(){  return sideB;	}
    public double getC(){  return sideC;	}
    public void setABC(double s1,double s2,double s3) throws IllegalTriangleException{
        if((s1+s2<=s3)||(s1+s3<=s2)||(s3+s2<=s1)||s1<=0||s2<=0||s3<=0){
            throw new IllegalTriangleException(s1,s2,s3);
        }
        sideA=s1;
        sideB=s2;
        sideC=s3;
    }
    public double getArea(){
        double s=(sideA+sideB+sideC)/2;
        return Math.pow(s*(s-sideA)*(s-sideB)*(s-sideC), 0.5);
    }
    public double getPerimeter(){   return sideA+sideB+sideC; 	}

    public String toString(){
        return "The triangle: sideA = " + sideA+ " ,"+ "sideB = " + sideB + ","
                + "sideC = " +sideC + "\n"
                +"the area is "+ getArea()+"\n"
                +"the perimeter is "+getPerimeter();
    }
}

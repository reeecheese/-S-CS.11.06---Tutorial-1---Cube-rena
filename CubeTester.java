import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CubeTester {

    public static class Cube {
        //Cube has one single private integer variable called side
        private int side;
        //a getter method called getSide()
        public int getSide(){
            return side;
        }
        //a setter method called setSide(int side)
        public void setSide(int side){
            if(side>=1){
                this.side = side;
            }else{
                throw new IllegalArgumentException("A cube’s side length cannot be less than 1!");
        }}
        public int getSurfaceArea(){
            return side*2*6;
        }
        public int getVolume(){
            int volume = side*side*side;
            return volume;
        }
        public String toString(){
            return "Cube{side="+ side+ "}";
        }
        // takes no arguments (has no parameters) and sets side to 1.
        public Cube(){
            int side = 1;
        }
        //Side should never be less than 1.
        // If a user attempts to create a Cube with a side length less than 1,
        // ]an IllegalArgumentException will be thrown.
        public Cube(int inatilize){
            if(inatilize>=1){
                int side = inatilize;
            }else{
                throw new IllegalArgumentException("A cube’s side length cannot be less than 1!");
            }
        }
    }

    @Test
    public void TestNoArgumentConstructorNoException() {
        Cube cube = new Cube();
        assertTrue("Ensure that your no argument constructor has been implemented correctly!", cube.getSide() == 1);
    }

    @Test
    public void TestSingleArgumentConstructorNoException() {
        Cube cube = new Cube(5);
        assertTrue("Ensure that your single argument constructor has been implemented correctly!", cube.getSide() == 5);
    }

    @Test
    public void TestSingleArgumentConstructorNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{ new Cube(-1);});
    }

    @Test
    public void TestSingleArgumentConstructorZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{ new Cube(0);});
    }

    @Test
    public void TestSetter() {
        Cube cube = new Cube(5);
        cube.setSide(7);
        assertTrue("Ensure that your setter method has been implemented correctly!", cube.getSide() == 7);
    }

    @Test
    public void TestSetterNegative() {
        Cube cube = new Cube(5);
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{ cube.setSide(-1);});
    }

    @Test
    public void TestSetterZero() {
        Cube cube = new Cube(5);
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{ cube.setSide(0);});
    }

    @Test
    public void TestVolume() {
        Cube cube = new Cube(5);
        int volume = cube.getVolume();
        assertTrue("Ensure that your getVolume method has been implemented correctly!", volume == 125);
    }

    @Test
    public void TestVolumeTwo() {
        Cube cube = new Cube(7);
        int volume = cube.getVolume();
        assertTrue("Ensure that your getVolume method has been implemented correctly!", volume == 343);
    }

    @Test
    public void TestSurfaceArea() {
        Cube cube = new Cube(5);
        int surfaceArea = cube.getSurfaceArea();
        assertTrue("Ensure that your getSurfaceArea method has been implemented correctly!", surfaceArea == 150);
    }

    @Test
    public void TestSurfaceAreaTwo() {
        Cube cube = new Cube(7);
        int surfaceArea = cube.getSurfaceArea();
        assertTrue("Ensure that your getSurfaceArea method has been implemented correctly!", surfaceArea == 294);
    }

}

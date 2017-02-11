package Week2.Homework;

/**
 * Created by vitalii on 30.01.17.
 */
public class FactoryMethod2 {

    public static void main(String[] args) {
        TurtleMom mom1 = new WaterTurtleMom();
        Turtle turtle1 = mom1.birhtTurtle();
        turtle1.walk();

        TurtleMom mom2 = new TurtleShellMom();
        Turtle turtle2 = mom2.birhtTurtle();
        turtle2.walk();
    }
}

interface Turtle{
    void walk();
}

class WaterTurtle implements Turtle{

    @Override
    public void walk() {
        System.out.println("Lets go to swim");
    }
}

class TurtleShell implements Turtle{

    @Override
    public void walk() {
        System.out.println("I'd like to eat some grass");
    }
}

interface TurtleMom{
    Turtle birhtTurtle();
}

class WaterTurtleMom extends WaterTurtle implements TurtleMom{

    @Override
    public Turtle birhtTurtle() {
        return new WaterTurtle();
    }
}

class TurtleShellMom extends TurtleShell implements TurtleMom{

    @Override
    public Turtle birhtTurtle() {
        return new TurtleShell();
    }
}
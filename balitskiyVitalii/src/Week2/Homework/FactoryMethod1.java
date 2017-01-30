package Week2.Homework;

/**
 * Created by vitalii on 30.01.17.
 */
public class FactoryMethod1 {

    public static void main(String[] args) {

        MouseCreator creator1 = new RadioMouseCreator();

        Mouse mouse1 = creator1.getMouse();
        mouse1.click();

        MouseCreator creator2 = new WireMouseCreator();
        Mouse mouse2 = creator2.getMouse();
        mouse2.click();
    }



}

interface Mouse{
    void click();
}

class RadioMouse implements Mouse{
    public void click(){
        System.out.println("Radio click");
    }
}

class WireMouse implements Mouse{
    public void click(){
        System.out.println("Wire click");
    }
}

interface MouseCreator{
    public Mouse getMouse();
}

class RadioMouseCreator implements MouseCreator{
    @Override
    public Mouse getMouse() {
        return new RadioMouse();
    }
}

class WireMouseCreator implements MouseCreator{
    @Override
    public Mouse getMouse() {
        return new WireMouse();
    }
}
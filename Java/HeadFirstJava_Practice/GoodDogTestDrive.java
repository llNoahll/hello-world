package gooddogtestdrive;

import java.util.Scanner;


class GoodDog
{
    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int new_size) {
        size = new_size;
    }

    void bark()
    {
        if(size > 60) {
            System.out.println("Woof!");
        }
        else if(size > 14) {
            System.out.println("Ruff!");
        }
        else {
            System.out.println("Yip!");
        }
    }
}

public class GoodDogTestDrive
{
    public static void main(String[] args)
    {
        GoodDog one = new GoodDog();
        one.setSize(70);

        GoodDog two = new GoodDog();
        two.setSize(8);

        GoodDog three = new GoodDog();
        three.setSize(30);

        System.out.println("Dog size is " + one.getSize());

        one.bark();
        two.bark();
        three.bark();
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

public class Car extends Thread {

    private Entity entity;
    private int number;
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage car;
    private boolean canDrive;

    public int getX() {
        return this.x;
    }

    public void setCanDrive(boolean canDrive) {
        this.canDrive = canDrive;
    }

    public Car(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.canDrive = true;
        createCar();
    }

    public int distance() {
        return this.x + this.width;
    }

        private void createCar() {
        try {
            this.car = ImageIO.read(new File(Constants.CARS[0]));
        }catch (IOException e){
        }
    }


    public void run() {
        while (true) {
            if (this.canDrive) {
                System.out.println(this.canDrive);
                this.x += 30;
                Utils.sleep(500);

            }
            System.out.println("Thread is running");
        }
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(this.car, this.x, this.y, this.width, this.height, null);


    }

}

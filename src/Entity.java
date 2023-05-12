public class Entity {
    private int x;
    private int y;
    private int width;
    private int height;
    public Entity(int x, int y,int width,int height){
      this.x=x;
      this.y=y;
      this.width=width;
      this.height=height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

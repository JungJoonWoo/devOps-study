package day8.Ex2;

public class MoveablePoint extends Point {
  private int  xSpeed, ySpeed;


  public MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
    super(x, y);
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  public int getxSpeed() {
    return xSpeed;
  }

  public int getySpeed() {
    return ySpeed;
  }

  @Override
  public String toString() {
    return "MoveablePoint{" +
        "x=" + getX() +
        ", y=" + getY() +
        ", xSpeed=" + xSpeed +
        ", ySpeed=" + ySpeed +
        '}';
  }
}
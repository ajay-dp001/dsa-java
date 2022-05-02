package AAPrep_final_OnlyAmazon;

public class RobotBoundedINCircle {

  public static void main(String[] args) {
    String inst = "GGLLGGLLGG";
    System.out.println("Is Robot Bounded :" + isRobotBounded(inst));
  }

  private static boolean isRobotBounded(String inst) {
    // If Robot does not advance we're OK
    if (!inst.contains("G")) {
      return true;
    }
    // Position (x,y) of the robot on the plan
    int x = 0, y = 0;
    // Direction vector
    int dirX = 0, dirY = 1;
    // Go through instruction and apply simple linear algebra math
    for (char ch : inst.toCharArray()) {
      if (ch == 'L') {
        // Here we multiply the vector by the R2 rotation matrix
        // with an angle of +pi/2
        int temp = dirY;
        dirY = dirX;
        dirX = -temp;
      } else if (ch == 'G') {
        x += dirX;
        y += dirY;
      } else {
        // Here we multiply the vector by the R2 rotation matrix
        // with an angle of -pi/2 (right turn)
        int temp = dirY;
        dirY = -dirX;
        dirX = temp;
      }
    }
    // If the robot is back to the origin, or changed directions
    // then it can be conatined within a circle.
    return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);

  }

}

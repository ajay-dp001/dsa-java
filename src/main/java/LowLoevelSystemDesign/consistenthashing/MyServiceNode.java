package LowLoevelSystemDesign.consistenthashing;

import java.util.Arrays;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyServiceNode implements Node {

  private final String idc;
  public final String ip;
  public final int port;

  @Override
  public String getKey() {
    return idc + "-" + ip + "-" + port;
  }

  @Override
  public String toString() {
    return getKey();
  }

  public static void main(String[] args) {
    MyServiceNode nodeA = new MyServiceNode("IDC-1", "127.0.0.1", 8000);
    MyServiceNode nodeB = new MyServiceNode("IDC-2", "127.0.0.2", 8001);
    MyServiceNode nodeC = new MyServiceNode("IDC-3", "127.0.0.3", 8002);
    MyServiceNode nodeD = new MyServiceNode("IDC-4", "127.0.0.4", 8003);
    MyServiceNode nodeE = new MyServiceNode("IDC-5", "127.0.0.5", 8004);

    //Hash to Hash Ring
    ConsistentHashRouter<MyServiceNode> chr = new ConsistentHashRouter<>(
        Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE), 10);

    String requestIP1 = "192.168.0.1";
    String requestIP2 = "192.168.0.2";
    String requestIP3 = "192.168.0.3";
    String requestIP4 = "192.168.0.4";
    String requestIP5 = "192.168.0.5";

    goRoute(chr, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);
    chr.remove(nodeB);
    System.out.println("....Remove Node Online " + nodeB.getKey() + "....");

    goRoute(chr, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);
  }

  private static void goRoute(ConsistentHashRouter<MyServiceNode> chr, String... requestIPs) {
    for (String requestIp : requestIPs) {
      System.out.println(requestIp + " is route to " + chr.routeNode(requestIp));
    }
  }
}

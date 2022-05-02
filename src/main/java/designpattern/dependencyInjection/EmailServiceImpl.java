package designpattern.dependencyInjection;

public class EmailServiceImpl implements MessageService {

  @Override
  public void sendMessage(String str, String rec) {
    System.out.println("Email is send to Recipient :" + rec + " with message :" + str);
  }
}

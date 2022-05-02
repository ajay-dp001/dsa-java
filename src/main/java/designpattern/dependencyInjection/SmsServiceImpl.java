package designpattern.dependencyInjection;

public class SmsServiceImpl implements MessageService {

  @Override
  public void sendMessage(String str, String rec) {
    System.out.println("Sms is send to Recipient :" + rec + " with message :" + str);
  }
}

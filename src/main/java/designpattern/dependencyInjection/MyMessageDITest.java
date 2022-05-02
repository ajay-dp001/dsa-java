package designpattern.dependencyInjection;

import com.journaldev.java.dependencyinjection.consumer.Consumer;

public class MyMessageDITest {

  public static void main(String[] args) {
    String msg = "Hi Ajay";
    String phone = "9008045723";
    String email = "aja.dp001@gmail.com";
    MessageServiceInjector injector = null;
    Consumer app = null;

    injector = new EmailServiceInjector();
    app = injector.getConsumer();
    app.processMessage(msg, email);

    injector = new SMSServiceInjector();
    app = injector.getConsumer();
    app.processMessage(msg, phone);
  }

}

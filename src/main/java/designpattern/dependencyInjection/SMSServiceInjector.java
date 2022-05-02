package designpattern.dependencyInjection;

import com.journaldev.java.dependencyinjection.consumer.Consumer;

public class SMSServiceInjector implements MessageServiceInjector {

  @Override
  public Consumer getConsumer() {
    return new MyDIApplication(new SmsServiceImpl());
  }
}

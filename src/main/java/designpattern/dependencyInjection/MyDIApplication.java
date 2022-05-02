package designpattern.dependencyInjection;

import com.journaldev.java.dependencyinjection.consumer.Consumer;

public class MyDIApplication implements Consumer {

  private MessageService messageService;

  public MyDIApplication(MessageService msvc) {
    this.messageService = msvc;
  }

  @Override
  public void processMessage(String msg, String rec) {
    this.messageService.sendMessage(msg, rec);
  }
}

package com.journaldev.java.dependencyinjection.consumer;

import com.journaldev.java.dependencyinjection.service.MessageServie;

public class MyDIApplication implements Consumer {

  private MessageServie messageServie;

  public MyDIApplication(MessageServie msvc) {
    this.messageServie = msvc;
  }

  @Override
  public void processMessage(String str, String msg) {
    this.messageServie.sendMessage(str, msg);
  }
}

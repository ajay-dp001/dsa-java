package com.journaldev.java.dependencyinjection.service;

public class SMSServiceImpl implements MessageServie {

  @Override
  public void sendMessage(String msg, String rec) {
    System.out.println("SMS send to " + rec + " with message :" + msg);
  }

}

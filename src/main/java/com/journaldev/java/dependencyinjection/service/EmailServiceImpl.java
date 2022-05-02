package com.journaldev.java.dependencyinjection.service;

public class EmailServiceImpl implements MessageServie {

  @Override
  public void sendMessage(String msg, String rec) {
    System.out.println("Email send to " + rec + " with message :" + msg);
  }
}

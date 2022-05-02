package com.journaldev.java.legacy;

public class MyApplication {

  private EmailService emailService = new EmailService();

  public void processMessage(String msg, String rec) {
    this.emailService.sendEmail(msg, rec);
  }

}

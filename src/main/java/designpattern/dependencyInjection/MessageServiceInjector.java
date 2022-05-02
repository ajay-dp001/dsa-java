package designpattern.dependencyInjection;

import com.journaldev.java.dependencyinjection.consumer.Consumer;

public interface MessageServiceInjector {

  Consumer getConsumer();
}

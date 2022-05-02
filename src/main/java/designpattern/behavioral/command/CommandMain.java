package designpattern.behavioral.command;

public class CommandMain {

  public static void main(String[] args) {

    TextFileOperationExecutor operationExecutor = new TextFileOperationExecutor();

    operationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("File-1.txt")));
    operationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("File-1.txt")));
  }

}

package designpattern.creational.factory;

public class ShapeFactory extends AbstractFactory {

  public Shape getShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("Circle")) {
      return new Circle();
    }
    if (shapeType.equalsIgnoreCase("Square")) {
      return new Square();
    }
    if (shapeType.equalsIgnoreCase("Rectangle")) {
      return new Rectangle();
    }
    return null;
  }


  @Override
  public Shape getAbstractShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("Circle")) {
      return new Circle();
    }
    if (shapeType.equalsIgnoreCase("Square")) {
      return new Square();
    }
    if (shapeType.equalsIgnoreCase("Rectangle")) {
      return new Rectangle();
    }
    return null;
  }
}

package designpattern.creational.factory;

public class RoundedShapeFactory extends AbstractFactory {

  @Override
  public Shape getAbstractShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new RoundedRectangle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new RoundedSquare();
    }
    return null;
  }
}

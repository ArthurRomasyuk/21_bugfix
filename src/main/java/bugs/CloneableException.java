package bugs;

public class CloneableException {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car();
        Car carClone = (Car) car.clone();

    }

    //please provide possibility to clone Car model
}


class Car implements Cloneable {
    private String color;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//подписал интерфейс маркер, добавил исключение и переопределил метод клон

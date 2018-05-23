package mmn14.exercise2;

public class VehicleAlreadyExistsException extends Exception {

    public VehicleAlreadyExistsException() {
        super("Can't add vehicle because vehicle with this License ID already exists!\n");
    }
}

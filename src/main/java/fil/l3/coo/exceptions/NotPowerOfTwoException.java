package fil.l3.coo.exceptions;

public class NotPowerOfTwoException extends Exception {
    public static final String message = "le nombre des compétiteurs n'est pas une puissance de 2";

    public NotPowerOfTwoException() {
        super(message);
    }
}

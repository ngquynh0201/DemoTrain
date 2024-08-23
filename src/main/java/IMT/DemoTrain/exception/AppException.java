package IMT.DemoTrain.exception;

public class AppException extends RuntimeException {

    public AppException(ErroCode erroCode) {
        super(erroCode.getMessage());
        this.erroCode = erroCode;
    }

    private ErroCode erroCode;

    public ErroCode getErroCode() {
        return erroCode;
    }

    public void setErroCode(ErroCode erroCode) {
        this.erroCode = erroCode;
    }
}

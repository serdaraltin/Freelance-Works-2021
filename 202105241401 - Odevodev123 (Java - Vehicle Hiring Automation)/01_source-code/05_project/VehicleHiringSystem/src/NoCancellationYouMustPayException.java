public class NoCancellationYouMustPayException extends Exception {
    private static final long serialVersionUID = 300348531700817723L;
    public NoCancellationYouMustPayException() {
        super("You need to pay");
    }
}

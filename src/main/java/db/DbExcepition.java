package db;

public class DbExcepition extends RuntimeException {

    private static final long serialVersionUid = 1l;

    public DbExcepition(String msg) {
        super(msg);
    }
}

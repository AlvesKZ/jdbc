package db;

public class DbIntegrityExcepition extends RuntimeException {

    private static final long serialVersionUid = 1l;

    public DbIntegrityExcepition(String msg) {
        super(msg);
    }
}

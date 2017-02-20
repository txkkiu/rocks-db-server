package rocksdb;


import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

/**
 * Created by koushikkrishnan on 2/8/17.
 */
public class SimpleRocksDB {

    private RocksDB db;

    public SimpleRocksDB(RocksDB db) {
        this.db = db;
    }

    public String get(String key) {
        String value = null;
        try {
            value = new String(db.get(key.getBytes()));
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void set(String key, String value) {
        try {
            db.put(key.getBytes(), value.getBytes());
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
    }
}
package rocksdb;

import org.rocksdb.RocksDB;
import org.rocksdb.Options;
import org.rocksdb.RocksDBException;
import rocksdb.SimpleRocksDB;


/**
 * Created by koushikkrishnan on 2/7/17.
 */
public class RocksDBBuilder {

    private Options options;
    private String path;
    private static boolean ROCKS_LIBRARY_LOADED = false;

    public RocksDBBuilder() {
        if (!ROCKS_LIBRARY_LOADED) {
            RocksDB.loadLibrary();
            ROCKS_LIBRARY_LOADED = true;
        }
        options = new Options().setCreateIfMissing(true);
    }

    public RocksDBBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public RocksDBBuilder withOptions(Options options) {
        this.options = options;
        return this;
    }

    public SimpleRocksDB build() {
        RocksDB db = null;
        try {
            db = RocksDB.open(options, path);
        } catch (RocksDBException e) {
            e.printStackTrace();
        }
        return new SimpleRocksDB(db);
    }

}
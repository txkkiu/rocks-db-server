package rocksdb;

import java.util.HashMap;

/**
 * Created by koushikkrishnan on 2/24/17.
 */
public class RocksDBFactory {

    private static HashMap<String, SimpleRocksDB> dbFlyWeight = new HashMap<>();
    private static RocksDBBuilder builder = new RocksDBBuilder();
    
    public static SimpleRocksDB getDB(String databaseName) {
        return dbFlyWeight.computeIfAbsent(databaseName, k -> builder.withPath("rocks_databases/" + k).build());
    }

}

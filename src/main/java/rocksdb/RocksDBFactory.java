package rocksdb;

import java.util.HashMap;

/**
 * Created by koushikkrishnan on 2/24/17.
 */
public class RocksDBFactory {

    private static HashMap<String, SimpleRocksDB> dbFlyWeight = new HashMap<>();

    public static SimpleRocksDB getDB(String databaseName) {
        dbFlyWeight.computeIfAbsent(databaseName, k -> new RocksDBBuilder().withPath("rocks_databases/" + databaseName).build());
        return dbFlyWeight.get(databaseName);
    }

}

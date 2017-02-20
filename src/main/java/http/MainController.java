package http;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import rocksdb.RocksDBBuilder;
import rocksdb.SimpleRocksDB;

@RestController
public class MainController {

    private SimpleRocksDB rocksDB = new RocksDBBuilder()
                                            .withPath("db")
                                            .build();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("key") String key) {
        return rocksDB.get(key);
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public void set(@RequestParam("key") String key,@RequestParam("value") String value) {
        rocksDB.set(key, value);
    }
    
}

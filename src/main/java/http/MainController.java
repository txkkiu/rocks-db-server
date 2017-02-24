package http;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ValueResponse;
import org.springframework.web.bind.annotation.*;
import rocksdb.RocksDBBuilder;
import rocksdb.RocksDBFactory;
import rocksdb.SimpleRocksDB;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;

@RestController
public class MainController {

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("db") String db, @RequestParam("key") String key) {
        SimpleRocksDB rocksDB = RocksDBFactory.getDB(db);
        ValueResponse value = new ValueResponse(rocksDB.get(key));
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, value);
        } catch (IOException e) {
            e.printStackTrace();
            stringWriter.write("{\"success\": false}");
        }
        return stringWriter.toString();
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public String set(@RequestParam("db") String db, @RequestParam("key") String key, @RequestParam("value") String value) {
        return "{\"success\": " + RocksDBFactory.getDB(db).set(key, value) + "}";
    }
    
}

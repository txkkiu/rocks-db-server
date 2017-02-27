package http;

import models.ModelUtils;
import models.Response;
import models.ValueResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocksdb.RocksDBFactory;
import rocksdb.SimpleRocksDB;

@Controller
public class MainController extends RocksDBFactory {

    @RequestMapping(name = "/get_key", method = RequestMethod.GET)
    public String get(@RequestParam("db") String db, @RequestParam("key") String key) {
        SimpleRocksDB rocksDB = RocksDBFactory.getDB(db);
        ValueResponse valueResponse = new ValueResponse(rocksDB.get(key));
        return ModelUtils.write(valueResponse);
    }

    @RequestMapping(name = "/set_key", method = RequestMethod.POST)
    public String set(@RequestParam("db") String db, @RequestParam("key") String key, @RequestParam("value") String value) {
        SimpleRocksDB rocksDB = RocksDBFactory.getDB(db);
        Response response = new Response(rocksDB.set(key, value));
        return ModelUtils.write(response);
    }

}

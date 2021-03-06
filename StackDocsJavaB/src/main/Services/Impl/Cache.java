package Services.Impl;

import Services.ICache;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cache implements ICache {

    private Map<String, Object> cachedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Long> cachedLiveTime = Collections.synchronizedMap(new HashMap<>());
    private long timeToLive = 120;


    //------------Singleton-----------
    private static Cache instance = null;

    private Cache() {}

    public static Cache getInstance() {

        if(instance == null) {
            instance = new Cache();
            return instance;
        }
        return instance;
    }
    //---------------------------------


    @Override
    public void put(String key, Object obj) {

        cachedObjects.put(key, obj);
        cachedLiveTime.put(key, System.currentTimeMillis() + timeToLive * 1000);
    }

    @Override
    public Object get(String key) {
        if (!cachedObjects.containsKey(key)) {
            return null;
        }
        if (System.currentTimeMillis() > cachedLiveTime.get(key)) {
            remove(key);
            return null;
        }
        return cachedObjects.get(key);
    }

    @Override
    public void remove(String key) {
        cachedObjects.remove(key);
        cachedLiveTime.remove(key);
    }
}

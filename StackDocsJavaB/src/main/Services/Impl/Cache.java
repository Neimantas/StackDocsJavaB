package Services.Impl;

import Services.CacheThread;
import Services.ICache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cache implements ICache {

    private Map<String, Object> cachedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, CacheThread> cachedTreads = Collections.synchronizedMap(new HashMap<>());
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
        if (cachedObjects.containsKey(key)) {
            cachedTreads.get(key).addTime();
        } else {
            CacheThread t = new CacheThread(key);
            t.start();
            cachedObjects.put(key, obj);
            cachedTreads.put(key, t);
        }
    }

    @Override
    public Object get(String key) {
        if (!cachedObjects.containsKey(key)) return null;
        return cachedObjects.get(key);
    }

    @Override
    public void remove(String key) {
        cachedObjects.remove(key);
        cachedTreads.remove(key);
    }

    public long getTimeToLive() {
        return timeToLive;
    }
}

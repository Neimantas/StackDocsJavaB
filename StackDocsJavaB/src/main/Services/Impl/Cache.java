package Services.Impl;

import Services.ICache;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cache implements ICache {

    private Map<String, Object> cachedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Thread> cachedTreads = Collections.synchronizedMap(new HashMap<>());
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
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timeToLive * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                remove(key);
            }
        });
        t.setDaemon(true);
        cachedObjects.put(key, obj);
        cachedTreads.put(key, t);
        t.start();
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
}

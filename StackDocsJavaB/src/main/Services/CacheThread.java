package Services;

import Services.Impl.Cache;

public class CacheThread extends Thread {
    private String key;

    public CacheThread(String key) {
        this.key = key;
        setDaemon(true);
    }

    int counter = 0;

    public void addTime() {
        counter++;
    }

    @Override
    public void run() {
        while(counter >= 0) {
            try {
                Thread.sleep(Cache.getInstance().getTimeToLive() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter--;
        }
        Cache.getInstance().remove(key);
    }
}

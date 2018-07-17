package Models.CONS;

public enum Settings {
    //Its the amount of size sent to frontEnd, and its equals amount of lines of topics will be displayed after any search
    LIST_SIZE(10),
    //Its the amount of time items will be saved in Cache.class, now its set to 120 seconds
    LIVE_TIME(120000);

    Settings(Object Settings) {
        settings = Settings;
    }

    private final Object settings;

    public Object get() {
        return settings;
    }
}

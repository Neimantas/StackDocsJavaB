package Models.CONS;

public enum Settings {
    //Its the amount of size sent to frontEnd, and its equals amount of lines of topics will be displayed after any search
    LIST_SIZE(10),
    //Its the amount of time items will be saved in Cache.class, now its set to 120 seconds
    LIVE_TIME(120000),
    //keyword put dropdown into cash
    DROPDOWN_CASH("dropdownGet"),
    //languages ​​to display in the drop down menu
    DROPDOWN_LANGUAGES(new String[]{"3", "4", "5", "8"});

    Settings(Object Data) {
        settings = Data;
    }

    private final Object settings;

    public Object get() {
        return settings;
    }
}

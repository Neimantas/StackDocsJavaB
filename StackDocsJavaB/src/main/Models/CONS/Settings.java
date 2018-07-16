package Models.CONS;

public enum Settings {
    //Its the amount of size sent to frontEnd, and its equals amount of lines of topics will be displayed after any search
    LIST_SIZE(10);

    Settings(int Data) {
        data = Data;
    }

    private final int data;

    public int getData() {
        return data;
    }
}

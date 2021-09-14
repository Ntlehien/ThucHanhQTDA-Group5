package group5.duan.library.enumration;

public enum UserRole {
    user("user",0),
    admin("admin",1);

    private final String key;
    private final Integer value;

    UserRole(String key, Integer value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}

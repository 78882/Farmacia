package farmacia;

public class Medicine {
    private String name;
    private String description;
    private String time;
    private boolean taken;

    public Medicine(String name, String description, String time, boolean taken) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.taken = taken;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public boolean isTaken() { return taken; }
    public void setTaken(boolean taken) { this.taken = taken; }
}

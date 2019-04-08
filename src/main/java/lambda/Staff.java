package lambda;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-04-02 10:57
 */
public class Staff {
    private int id;
    private String name;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

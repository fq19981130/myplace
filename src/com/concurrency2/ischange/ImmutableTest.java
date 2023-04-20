package src.com.concurrency2.ischange;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {

    private final int age;
    private final String name;
    private final List<String> list;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }
}

package jcip.examples;

import java.util.*;

import net.jcip.annotations.*;

/**
 * PersonSet
 * <p/>
 * Using confinement to ensure thread safety
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class PersonSet {
    @GuardedBy("this") private final Set<Person> mySet = new HashSet<Person>();
    //HashSet原本是非线程安全的
    //在本例中，通过调用synchronized的方法，可以使对HashSet的操作线程安全化，需要获得PersonSet上面的锁
    //mySet被私有化从而不会发生逸出
    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
    //Person接口
}

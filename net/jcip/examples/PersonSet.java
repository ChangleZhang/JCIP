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
    //HashSetԭ���Ƿ��̰߳�ȫ��
    //�ڱ����У�ͨ������synchronized�ķ���������ʹ��HashSet�Ĳ����̰߳�ȫ������Ҫ���PersonSet�������
    //mySet��˽�л��Ӷ����ᷢ���ݳ�
    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
    //Person�ӿ�
}

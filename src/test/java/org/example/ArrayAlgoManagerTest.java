package org.example;

import org.junit.Before;
import org.junit.Test;

public class ArrayAlgoManagerTest {

    private ArrayAlgoManager manager;

    @Before
    public void create(){
        manager = new ArrayAlgoManager();
    }

    @Test
    public void missingNumber(){
        int[] data = {0,1,2,3,4,5,6,7,9};
        System.out.println(manager.missingNumber(data));
    }
}

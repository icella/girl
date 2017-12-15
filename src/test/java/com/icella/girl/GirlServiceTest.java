package com.icella.girl;

import com.icella.girl.domain.Girl;
import com.icella.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findoneTest(){
        Girl girl = girlService.findOne(4);
        Assert.assertEquals(new Integer(44), girl.getAge());
    }
}

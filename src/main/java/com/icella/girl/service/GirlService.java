package com.icella.girl.service;

import com.icella.girl.domain.Girl;
import com.icella.girl.enums.ResultEnum;
import com.icella.girl.exception.GirlException;
import com.icella.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girl = new Girl();
        girl.setAge(21);
        girl.setName("A");

        girlRepository.save(girl);

        girl = new Girl();
        girl.setAge(33);
        girl.setName("Baa");

        girlRepository.save(girl);
    }

    public void getAge(Integer id) throws GirlException {
        Girl girl = girlRepository.findOne(id);

        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.SO_LITTLE);
        } else if(age > 10 && age < 16){
            throw new GirlException(ResultEnum.AlSO_LITTLE);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}

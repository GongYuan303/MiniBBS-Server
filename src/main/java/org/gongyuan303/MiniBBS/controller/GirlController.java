package org.gongyuan303.MiniBBS.controller;

import org.gongyuan303.MiniBBS.aspect.HttpAspect;
import org.gongyuan303.MiniBBS.domain.Result;
import org.gongyuan303.MiniBBS.enums.ResultEnum;
import org.gongyuan303.MiniBBS.repository.GirlRepository;
import org.gongyuan303.MiniBBS.service.GirlService;
import org.gongyuan303.MiniBBS.domain.Gril;
import org.gongyuan303.MiniBBS.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping(value = "/gril")
    public List<Gril> getGrils(){
        logger.info("getGrils2222222222");
        return girlRepository.findAll();
    }

    /**
     * 新增一条数据
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping(value = "/addGril")
    public Gril addGril(@RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize){
        Gril gril = new Gril();
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return girlRepository.save(gril);
    }

    /**
     * 新增一条数据,注入表单校验，获得校验结果信息
     * @param gril
     * @return
     */
    @PostMapping(value = "/addGril2")
    public Result addGril2(@RequestBody Gril gril, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        gril.setAge(gril.getAge());
        gril.setCupSize(gril.getCupSize());
        return ResultUtil.success(girlRepository.save(gril));
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @GetMapping(value = "/findOne")
    public Gril findOne(@RequestParam("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 事物的处理
     */
    @PostMapping(value = "/GirlTwo")
    public void GirlTwo(){
        girlService.insertTwo();
    }

    @PostMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);

    }
}

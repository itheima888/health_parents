package com.changgou.search.controller;

import com.changgou.search.service.SearchService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName SearchController
 * @Description
 * @Author 传智播客
 * @Date 11:37 2020/9/9
 * @Version 2.1
 **/
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    /**
     * @Description 商品检索
     **/
    @GetMapping
    public Map<String, Object> search(@RequestParam(required = false) Map<String, String> searchMap){
        Map<String, Object> resultMap = searchService.search(searchMap);
        return resultMap;
    }


    /**
     * @Description 数据导入
     **/
    @RequestMapping("/importData")
    public Result importData(){
        searchService.importDataToEs();
        return new Result(true, StatusCode.OK, "数据导入成功");
    }




}

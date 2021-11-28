/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codingtest.microservices;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Rishabh
 */
@RestController
public class TestServices {
    
    @RequestMapping(path= "/hoodfiller", method = RequestMethod.POST)
    public int test(@RequestBody Map<String, Object> payload) {
        int ans = CalculateList.Count(payload.get("present_weights"),payload.get("present_weights").length,payload.get("hood_capacity"));
        return ans;
    }
}

package com.reborn.controller;

import com.reborn.entity.*;
import com.reborn.redis.RStringUtil;
import com.reborn.service.UploadFileService;
import com.reborn.service.UserAddressService;
import com.reborn.service.UserService;
import com.reborn.tool.Message;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@MultipartConfig
@RequestMapping(value = "/first")
public class FirstController {

    @Resource
    private UserService userService;
    @Resource
    private UserAddressService userAddressService;
    @Resource
    private UploadFileService uploadFileService;
    @Resource
    private JdbcTemplate oracleJdbcTemplate;
    @Resource
    private RStringUtil rStringUtil;

    @RequestMapping(value = "/handleRequest")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println(userService.findUserById2(11));
        return "product";
    }

    @RequestMapping("/handleObject")
    public String handleObject(User user,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(user.getLoginName());
        System.out.println(user.getPassword());
        Message.returnMessage(user.getLoginName()+" "+user.getPassword(),response);
        return null;
    }

    @RequestMapping("/pojo")
    public String pojo(User user){
        String loginName = user.getLoginName();
        UserInfo userInfo = user.getUserInfo();
        List<UserAddress> userAddresses = userInfo.getUserAddressList();
        System.out.println("loginName="+loginName);
        System.out.println("firstName="+userInfo.getFirstName());
        System.out.println("country="+userAddresses.get(0).getCountry());
        return null;
    }

    @RequestMapping("/convertDate")
    public String convertDate(LocalDate localDate){
        UserAddress userAddress = userAddressService.getById(1);
        System.out.println("localDate="+localDate);
        System.out.println(userAddress);
        return null;
    }

    @RequestMapping(value = "/ajax",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> ajax(HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();

        map.put("msg",request.getParameter("name"));
        return map;
    }

    @RequestMapping("/arrayData")
    public String arrayData(Integer[] ids){
        for(int id:ids){
            System.out.println(userService.findUserById2(id));
        }
        return "dataTest";
    }

    @RequestMapping("/listData")
    public String listData(Users userList){
        List<User> users = userList.getUsers();
        System.out.println(users);
        return "dataTest";
    }

    @RequestMapping("/jsonData")
    public @ResponseBody User jsonData(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/restfulData/{id}",method = RequestMethod.GET)
    public @ResponseBody User restfulData(@PathVariable("id") String id){
        User user = userService.findUserById2(Integer.valueOf(id));
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/fileUpload")
    public String fileUpload(HttpServletRequest request, @RequestParam("files") List<MultipartFile> files) throws IOException {
        System.out.println("fileUpload");
        if(!files.isEmpty()){
            for(MultipartFile uploadFile:files){
                String dir = request.getServletContext().getRealPath("/upload/");
                File savePath = new File(dir);
                if(!savePath.exists())
                    savePath.mkdirs();
                String fileName = uploadFile.getOriginalFilename();
                String saveFileName = UUID.randomUUID().toString();
                File file = new File(dir+saveFileName+"."+fileName.substring(fileName.lastIndexOf(".")+1));

                uploadFile.transferTo(file);
                UploadFile uploadFile1 = new UploadFile();
                uploadFile1.setFileName(saveFileName);
                uploadFile1.setType(fileName.substring(fileName.lastIndexOf(".")+1));
                uploadFile1.setUploadDate(LocalDateTime.now());
                uploadFile1.setPath(dir);
                uploadFileService.add(uploadFile1);

                System.out.println("File:"+saveFileName+" upload success");
            }
        }
        return "dataTest";
    }

    @RequestMapping(value = "/fileDownload1/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> fileDownload(@PathVariable("id") String id) throws IOException {
        System.out.println("method:fileDownload "+id);
        UploadFile downloadFile = uploadFileService.getById(Integer.valueOf(id));
        File file = new File(downloadFile.getPath()+downloadFile.getFileName()+"."+downloadFile.getType());
        HttpHeaders headers = new HttpHeaders();
        System.out.println(downloadFile.getFileName()+"."+downloadFile.getType());
        headers.setContentDispositionFormData("attachment",downloadFile.getFileName()+"."+downloadFile.getType());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/oracleTest")
    public String oracleTest(){
        List<Product> products = oracleJdbcTemplate.query("select * from pwk.product",new BeanPropertyRowMapper<>(Product.class));
        System.out.println(products);
        return "dataTest";
    }

    @RequestMapping(value = "/redisListAdd/{key}/{value}",method = RequestMethod.GET)
    public @ResponseBody String redisStringAdd(@PathVariable("key") String key,@PathVariable("value") String value){
        System.out.println(key);
        System.out.println(value);
        rStringUtil.set(key,value);
        return key+":"+value;
    }

    @RequestMapping(value = "/redisSessionTest")
    public String redisSessionTest(HttpServletRequest request){
        request.getSession().setAttribute("redisSession","success");
        return "dataTest";
    }

}


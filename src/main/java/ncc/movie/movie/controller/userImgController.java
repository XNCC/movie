package ncc.movie.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class userImgController {

    @PostMapping("/uploadUserImgs")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String  uploadUserImgs(@RequestParam("img") MultipartFile img) throws IOException {
        String path1=UUID.randomUUID().toString()+"ncc.jpg";
        String path= "/imgs/"+path1;
        BufferedOutputStream videoout=new BufferedOutputStream(new FileOutputStream("D:/imgs/"+path1));
        videoout.write(img.getBytes());
        videoout.flush();
        videoout.close();
        System.out.println("123");
      return path;
    }

}

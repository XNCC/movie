package ncc.movie.movie.controller;

import ncc.movie.movie.pojo.PictureBean;
import ncc.movie.movie.utils.BaseParamats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.SQLException;

@Controller
public class sideshowController {
        @Autowired
        ncc.movie.movie.service.sideshowService sideshowService;
    @RequestMapping("/slideshow")
    public String sideshows(Model model) throws SQLException {
       String img1= sideshowService.fidPicture(1);
       String img2=  sideshowService.fidPicture(2);
       model.addAttribute("img1", img1);
       model.addAttribute("img2",img2);
       return "slideshow";
    }
    @PostMapping("/uploadImgs")
    public String upload(@RequestParam("file1") MultipartFile file1
            ,@RequestParam("file2") MultipartFile file2) throws IOException, SQLException {

        String img1=file1.getOriginalFilename();
        String img2=file2.getOriginalFilename();
        //上传轮播图1     路径保存在数据库
        String path1="D:/sideshow/"+img1;
        BufferedOutputStream out1=new BufferedOutputStream(new FileOutputStream(path1));
        out1.write(file1.getBytes());
        out1.flush();
        out1.close();
        //上传轮播图2    路径保存在数据库
        String path2="D:/sideshow/"+img2;
        BufferedOutputStream out2=new BufferedOutputStream(new FileOutputStream(path2));
        out2.write(file2.getBytes());
        out2.flush();
        out2.close();
        System.out.println(img1+"  "+img2);
        PictureBean pictureBean1=new PictureBean();
        PictureBean pictureBean2=new PictureBean();
        pictureBean1.setPicture_id(1);
        pictureBean1.setPicture_url("/sideshow/"+img1);
        pictureBean2.setPicture_id(2);
        pictureBean2.setPicture_url("/sideshow/"+img2);
        // 存储
        sideshowService.uptPicture(1,pictureBean1);
        sideshowService.uptPicture(2,pictureBean2);
        return "redirect:slideshow";
    }

    //远程轮播图ImageIO.write(new BufferedImage(),"jpg", httpServletResponse.getOutputStream())
    @RequestMapping(value="/lblin/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void  sideshows(@PathVariable("id") int id,HttpServletResponse httpServletResponse) throws SQLException, IOException {
        if (id==1){
            String img1= sideshowService.fidPicture(1);
            String[] split = img1.split("/");
            try{
                ServletOutputStream os = httpServletResponse.getOutputStream();
                BufferedImage image = ImageIO.read(new File("D:/sideshow/"+split[2]));
                ImageIO.write(image,"jpg",os);
            }catch (Exception e){}
        }else if(id==2){
            String img2=  sideshowService.fidPicture(2);
            String[] split = img2.split("/");
            System.out.println("D:/sideshow/"+split[2]);
            try{
                ServletOutputStream os = httpServletResponse.getOutputStream();
                BufferedImage image = ImageIO.read(new File("D:/sideshow/"+split[2]));
                ImageIO.write(image,"jpg",os);
            }catch (Exception e){}

        }

    }



}

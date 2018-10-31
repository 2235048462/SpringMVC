package controller;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/uploadImage")
    public ModelAndView upload ( HttpServletRequest request, UploadedImageFile file ) throws IOException {
        String name = RandomStringUtils.randomAlphanumeric ( 10 ); // 获取随机文件名称
        String newFileName = name + ".jpg";
        /*获取web目录下的image目录,存放上传后的文件*/
        File newFile = new File ( request.getServletContext ().getRealPath ( "/image" ), newFileName );
        newFile.getParentFile ().mkdirs ();
        file.getImage ().transferTo ( newFile ); // 复制文件

        ModelAndView mav08 = new ModelAndView ( "showUploadedFile" );
        mav08.addObject ( "imageName", newFileName );
        return mav08;
    }
}

package pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    MultipartFile image; // image必须与upload.jsp中image一致

    public MultipartFile getImage () {
        return image;
}

    public void setImage ( MultipartFile image ) {
        this.image = image;
    }
}

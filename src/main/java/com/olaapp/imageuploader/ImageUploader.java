package com.olaapp.imageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {
    private Cloudinary cloudinary ;

    public ImageUploader() {
      cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgusjhikn",
                "api_key", "725124615476959",
                "api_secret", "DVaoCf42P2Q3RNPu99KHx8vp_L8"));
    }
    public String uploadFile(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
             uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            /* todo; */
        }
        return uploadResult.get("url").toString();
    }

    public static void main(String[] args) throws IOException {
           //  File file = new File("C:\\image-uploader\\src\\images\\dogm.png");

  }
}

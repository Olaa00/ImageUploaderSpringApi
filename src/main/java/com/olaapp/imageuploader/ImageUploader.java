package com.olaapp.imageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.olaapp.imageuploader.model.Image;
import com.olaapp.imageuploader.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {
    private Cloudinary cloudinary ;
    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
      cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgusjhikn",
                "api_key", "725124615476959",
                "api_secret", "DVaoCf42P2Q3RNPu99KHx8vp_L8"));
    }
    public String uploadFileAndDBSave(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
             uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
             imageRepo.save(new Image(uploadResult.get("url").toString())); //zapis zdj do DB
        } catch (IOException e) {

        }
        return uploadResult.get("url").toString();
    }

    public static void main(String[] args) throws IOException {
           //  File file = new File("C:\\image-uploader\\src\\images\\dogm.png");

  }
}

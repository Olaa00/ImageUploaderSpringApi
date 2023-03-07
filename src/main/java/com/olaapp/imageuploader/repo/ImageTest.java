package com.olaapp.imageuploader.repo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgusjhikn",
                "api_key", "725124615476959",
                "api_secret", "DVaoCf42P2Q3RNPu99KHx8vp_L8"));

        File file = new File("C:\\image-uploader\\src\\images\\dogm.png");
        File file2 = new File("C:\\image-uploader\\src\\images\\dogo.png");
        File file3 = new File("C:\\image-uploader\\src\\images\\dogs.png");
        Map uploadResult = cloudinary.uploader().upload(file,ObjectUtils.emptyMap());
        Map uploadResult2 = cloudinary.uploader().upload(file2,ObjectUtils.emptyMap());
        Map uploadResult3 = cloudinary.uploader().upload(file3,ObjectUtils.emptyMap());
    }
}

package com.olaapp.imageuploader.repo;

import com.olaapp.imageuploader.model.Image;
import com.olaapp.imageuploader.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository <Image, Long> {

}

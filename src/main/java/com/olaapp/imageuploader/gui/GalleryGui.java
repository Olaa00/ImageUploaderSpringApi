package com.olaapp.imageuploader.gui;

import com.olaapp.imageuploader.ImageUploader;
import com.olaapp.imageuploader.model.Image;
import com.olaapp.imageuploader.repo.ImageRepo;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route ("gallery")
public class GalleryGui extends VerticalLayout {

    private ImageRepo imageUploader;
    @Autowired
    public GalleryGui(ImageRepo imageUploader){
     this.imageUploader = imageUploader;
        Label label1 = new Label();
     List<Image> all = imageUploader.findAll(); //pobieram wszytskie elemnty z DB
     all.stream().forEach(element ->{
         com.vaadin.flow.component.html.Image image =
                 new com.vaadin.flow.component.html.Image(element.getImageAdress(),"brak");
         System.out.println("Galeria dodanych zdjęć");
         add(image);
        });
    }

}

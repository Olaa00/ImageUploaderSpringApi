package com.olaapp.imageuploader.gui;

import com.olaapp.imageuploader.ImageUploader;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route ("upload")
public class UploadGui extends VerticalLayout {
 private ImageUploader imageUploader;
 @Autowired
   public UploadGui(ImageUploader imageUploader){
     this.imageUploader = imageUploader;


       TextField textField = new TextField();
       Label label = new Label();


       Button button = new Button("upload");
       button.addClickListener(buttonClickEvent -> {


         String uploadedImage = imageUploader.uploadFileAndDBSave(textField.getValue());//upload pliku ze sciezki podanej w textfieldzie
         Image image = new Image( uploadedImage, "brak zdjecia:(");
         label.setText("Upload zdjecia dokonany pomyślnie!");
         add(label);
         add(image);
       });
       add(textField);
       add(button);
   }

}

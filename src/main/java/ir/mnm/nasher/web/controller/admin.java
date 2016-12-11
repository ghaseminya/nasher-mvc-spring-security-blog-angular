package ir.mnm.nasher.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by mghasemy on 12/11/16.
 */
@Controller
public class admin {
    @RequestMapping(value="/upload.do", method= RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        String name="asdf";
        /*if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }*/
        System.out.println("!!!!!!!!!!!!!!!!!");
        return "asd";
    }
}

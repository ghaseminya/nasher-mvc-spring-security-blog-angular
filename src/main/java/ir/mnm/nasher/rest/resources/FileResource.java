package ir.mnm.nasher.rest.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Path;

/**
 * Created by mghasemy on 12/11/16.
 */
@Component
@Path("/uploadfile")
public class FileResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="/newDocument", method = RequestMethod.POST)
    public @ResponseBody
    void UploadFile(@RequestParam(value="file", required=true) MultipartFile file) {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
    }
}

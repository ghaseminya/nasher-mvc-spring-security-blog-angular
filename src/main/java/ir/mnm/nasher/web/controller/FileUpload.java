package ir.mnm.nasher.web.controller;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Created by mghasemy on 12/11/16.
 */
public class FileUpload extends HttpServlet {

    private static final long serialVersionUID = -8244073279641189889L;
    private final Logger log = Logger.getLogger(FileUpload.class.getName());


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //String fileName=file.getOriginalFilename();
        System.out.println(req.getParameterMap().size());

    }

}
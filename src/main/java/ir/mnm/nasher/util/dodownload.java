package ir.mnm.nasher.util;

/**
 * Created by mghasemy on 12/9/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.OutputStream;
        import java.net.URLDecoder;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.MultipartConfig;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammadghasemy
 */
@MultipartConfig
public class dodownload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String    fid = request.getPathInfo();

            if (fid == null) {

                response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                return;
            }

            File file = new File("/website/nasher/data", URLDecoder.decode(fid, "UTF-8"));


            if (!file.canRead()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                return;
            }
            String contentType = getServletContext().getMimeType(file.getName());

            // If content type is unknown, then set the default value.
            // For all content types, see: http://www.w3schools.com/media/media_mimeref.asp
            // To add new content types, add new mime-mapping entry in web.xml.
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            response.reset();
            response.setContentLength((int) file.length());

            response.setContentType(contentType);
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
            String ip = request.getRemoteAddr();
            String agent = request.getHeader("User-Agent");
        } catch (Exception s) {
            s.printStackTrace();
            return;
        }finally{

        }
    }

}
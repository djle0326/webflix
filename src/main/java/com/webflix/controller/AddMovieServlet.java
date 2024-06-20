package com.webflix.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.webflix.model.MovieInfoDAO;
import com.webflix.model.MovieInfoDTO;
import com.webflix.comm.FileUploadUtil;

@WebServlet("/webflix/addMovie")
@MultipartConfig
public class AddMovieServlet extends HttpServlet implements Controller {
    private static final String UPLOAD_DIR = "C:/Users/Minji/Desktop/webflix/src/main/webapp/static/images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movie_id");
        String title = request.getParameter("title");
        String releaseDate = request.getParameter("release_date");
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // 저장 경로 설정
        String uploadPath = UPLOAD_DIR;
        try (InputStream fileContent = filePart.getInputStream()) {
            FileUploadUtil.saveFile(uploadPath, fileName, fileContent);
        }

        // 영화 정보 저장
        MovieInfoDTO movie = new MovieInfoDTO();
        movie.setM_ID(movieId);
        movie.setM_name(title);
        movie.setImagePath("static/images/" + fileName);  // 파일 경로 저장
        movie.setM_summary("가필드 더 무비");  // summary 필드를 사용하는 것으로 변경
        movie.setM_see_num(0);
        movie.setM_likes(0);

        try {
            MovieInfoDAO movieDAO = MovieInfoDAO.getInstance();
            movieDAO.addMovie(movie);
            response.sendRedirect("/webflix/views/index.jsp");  // 상대 경로 수정
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/webflix/views/error.jsp");  // 상대 경로 수정
        }

        return new ModelAndView("index");
    }
}

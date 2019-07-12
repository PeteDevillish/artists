package pl.artists;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {
    private EntityDao<Artist> artistDao;

    public ArtistServlet() {
        artistDao = new EntityDao<Artist>(Artist.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artists", artistDao.findAll());
        req.getRequestDispatcher("artists.jsp")
                .forward(req, resp);

    }
}

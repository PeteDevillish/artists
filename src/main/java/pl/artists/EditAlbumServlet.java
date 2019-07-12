package pl.artists;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/edit-album")
public class EditAlbumServlet extends HttpServlet {

    private EntityDao<Artist> artistEntityDao;
    private EntityDao<Album> albumEntityDao;
    public EditAlbumServlet() {
        artistEntityDao = new EntityDao<Artist>(Artist.class);
        albumEntityDao = new EntityDao<Album>(Album.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artists", artistEntityDao.findAll());

        System.out.println(req.getAttribute("artists"));
        req.getRequestDispatcher("edit-album.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int albumId = Integer.parseInt(req.getParameter("aid"));
        Album album = new Album(name, artistEntityDao.findById(albumId));
        albumEntityDao.save(album);
//        Artist artist = req.getParameter("artist");

    }
}

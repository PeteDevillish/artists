package pl.artists;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/albums")
public class AlbumServlet extends HttpServlet {
    private EntityDao<Album> albums;
    private EntityDao<Artist> artists;
    public AlbumServlet() {
        this.albums = new EntityDao<Album>(Album.class);
        this.artists = new EntityDao<Artist>(Artist.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("albums", albums.findAll());
        req.setAttribute("artists", artists.findAll());
        req.getRequestDispatcher("albums.jsp")
                .forward(req, resp);
    }
}

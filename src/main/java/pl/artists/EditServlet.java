package pl.artists;
//4. Dokument artists.jsp ma przycisk, kierujący pod ścieżkę /edit-artist. Tworzymy serwlet obsługujący żądanie wysłane pod taką ścieżkę.
// Dla metody GET serwlet przekieruje obsługę żądania do dokumentu edit-artist.jsp. Dla metody POST serwlet utworzy artystę zgodnie z przekazanymi parametrami.
// Dokument edit-artist.jsp zawiera formularz do tworzenia artysty.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit-artists")
public class EditServlet extends HttpServlet {
        EntityDao<Artist> artistDao = new EntityDao<Artist>(Artist.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null){
            Artist artistDaoById = artistDao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("id", artistDaoById.getId());
            req.setAttribute("firstName", artistDaoById.getFirstName());
            req.setAttribute("lastName", artistDaoById.getLastName());
            req.setAttribute("isUpdate", true);
        }
        req.getRequestDispatcher("edit-artist.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null){
            Artist artistToUpdate = artistDao.findById(Integer.parseInt(req.getParameter("id")));
            artistToUpdate.setFirstName(req.getParameter("firstName"));
            artistToUpdate.setLastName(req.getParameter("lastName"));
            artistDao.update(artistToUpdate);
        }else {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Artist artist = new Artist(firstName, lastName);
        artistDao.save(artist);
        }

        resp.sendRedirect("/artists");
    }
}

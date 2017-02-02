package Week2.Homework.Appartaments.test;

import Week2.Homework.Appartaments.dao.JSONRentObjectDAO;
import Week2.Homework.Appartaments.model.AppartamentsStorage;
import Week2.Homework.Appartaments.Utils.FlatFactory;
import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAOTest {

    @Mock
    private JSONRentObjectDAO objectDAO;
    private AppartamentsStorage storage;

    @Before
    public void setUp(){
        storage = new AppartamentsStorage();
        storage.addFlat(FlatFactory.createFlat());
        when(objectDAO.getFlats(0)).thenReturn(new AppartamentsStorage());
    }
}


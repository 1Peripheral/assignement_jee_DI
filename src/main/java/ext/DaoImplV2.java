package ext;

import dao.IDao;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version API");
        return 30;
    }
}
package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao = null;

    public MetierImpl() {}

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul(){
        double data = dao.getData();
        return data*11.4;
    }

    public void setDao(IDao dao) {
       this.dao = dao;
    }
}

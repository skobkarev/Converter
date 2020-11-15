package converter.service;

import converter.entity.Convertation;

import java.util.List;

public interface ConvertationService {

    public List<Convertation> findAll();

    public void save(Convertation convertation);

}

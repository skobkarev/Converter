package converter.service;

import converter.dao.ConvertationRepository;
import converter.entity.Convertation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertationServiceImpl implements ConvertationService{

    public ConvertationRepository convertationRepository;

    @Autowired
    public ConvertationServiceImpl(ConvertationRepository convertationRepository) {

        this.convertationRepository = convertationRepository;

    }


    @Override
    public List<Convertation> findAll() {

        return convertationRepository.findAll();

    }

    @Override
    public void save(Convertation convertation) {

        convertationRepository.save(convertation);

    }

}

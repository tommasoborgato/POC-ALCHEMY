package com.poc.server.db;

import com.poc.shared.model.OutputObj;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by icttb0 on 18/12/2016.
 */
@Component
@Transactional
public class PocDaoImpl implements PocDao {

    public PocDaoImpl() {
    }

    @Override
    public OutputObj getOutputObj(long id) {
        return new OutputObj(id,"OutputObj with id: "+id);
    }
}

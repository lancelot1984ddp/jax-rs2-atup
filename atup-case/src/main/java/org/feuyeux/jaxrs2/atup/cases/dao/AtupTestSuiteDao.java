package org.feuyeux.jaxrs2.atup.cases.dao;

import java.util.List;

import org.feuyeux.jaxrs2.atup.core.dao.AtupDao;
import org.feuyeux.jaxrs2.atup.core.domain.AtupTestSuite;
import org.springframework.stereotype.Repository;

@Repository
public class AtupTestSuiteDao extends AtupDao<AtupTestSuite> {
    public AtupTestSuiteDao() {
        super();
    }

    public List<AtupTestSuite> findByStatus(Integer suiteStatus) {
        return entityManager.createNamedQuery("findBySuiteStatus", AtupTestSuite.class).setParameter("suiteStatus", suiteStatus).getResultList();
    }

    public AtupTestSuite findBySuiteName(String suiteName) {
        return entityManager.createNamedQuery("findBySuiteName", AtupTestSuite.class).setParameter("suiteName", suiteName).getSingleResult();
    }

    @Override
    public AtupTestSuite update(AtupTestSuite entity) {
        AtupTestSuite updateEntity = findBySuiteName(entity.getSuiteName());
        if (updateEntity != null) {
            entity.setSuiteId(updateEntity.getSuiteId());
            return super.update(entity);
        } else {
            return null;
        }
    }
}

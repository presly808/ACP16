package utils;


import dao.CandidateDao;
import dao.DaoCandidate;

public class DbOperationFactory {

    private static DaoCandidate daoCandidate;
    private static DbOperationFactory dbOperationFactory;

    private DbOperationFactory() {
        this.daoCandidate = new CandidateDao();
    }

    public static DbOperationFactory newInstance(){
        if (dbOperationFactory == null) {
            dbOperationFactory = new DbOperationFactory();
            return dbOperationFactory;
        } else
            return dbOperationFactory;
    }

    public DaoCandidate createDaoCandidate(){
        return daoCandidate;
    }
}

package com.tournament.services.matchservice;
import com.tournament.model.IMatch;
import com.tournament.persistence.MatchPersistence;
import com.tournament.persistence.interfaces.IMatchPersistence;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchService implements IMatchService {

    @Override
    public void saveMatch(IMatch iMatch){
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String startTime = timeFormat.format(currentDate);

        IMatchPersistence iMatchPersistence = new MatchPersistence();
        iMatch.setStartTime(startTime);

        iMatchPersistence.saveMatch(iMatch);
    }

}

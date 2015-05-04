package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Level;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class LevelFactory {
    public static Level createLevel(String level_name,
            List officeSpaces){
        Level level = new Level.Builder(level_name)
                .officeSpaces(officeSpaces)
                .build();
        return level;
    }
}

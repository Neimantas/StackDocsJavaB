package main.Services;

import main.Models.DTO.HigherServiceDTO;
import java.sql.SQLException;

public interface IHigherService {
    HigherServiceDTO getByThemeTytle(String title) throws SQLException;
    HigherServiceDTO getByTopicId(String topicId) throws SQLException;
    HigherServiceDTO getByDocTagId(String doctagId);
    HigherServiceDTO getByExampleId(String exampleId);
}

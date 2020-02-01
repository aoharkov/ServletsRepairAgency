package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.util.connector.Connector;
import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDaoImpl extends AbstractCrudPageableDaoImpl<Feedback> implements FeedbackDao {
    private static final String SAVE_QUERY = "INSERT INTO feedback (id, request_id, text, score) values(?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM feedback WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM feedback LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM feedback";
    private static final String UPDATE_QUERY = "UPDATE feedback SET request_id = ?, text = ?, score = ?, WHERE id = ?";

    public FeedbackDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, Feedback entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setInt(2, entity.getRequest().getId());
        preparedStatement.setString(3, entity.getText());
        preparedStatement.setInt(4, entity.getScore());
    }

    @Override
    protected Feedback mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Feedback.builder()
                .withId(resultSet.getInt("id"))
                .withRequest(getRequestById(resultSet.getInt("request_id")))
                .withText(resultSet.getString("text"))
                .withScore(resultSet.getInt("score"))
                .build();
    }

    public Request getRequestById(Integer id) {
        //todo
        return null;
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, Feedback entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequest().getId());
        preparedStatement.setString(2, entity.getText());
        preparedStatement.setInt(3, entity.getScore());
        preparedStatement.setInt(4, entity.getId());
    }
}

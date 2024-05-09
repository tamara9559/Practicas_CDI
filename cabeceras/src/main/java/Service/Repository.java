package Service;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> list() throws SQLException;
}


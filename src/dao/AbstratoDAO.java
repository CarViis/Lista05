package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstratoDAO implements AutoCloseable {

	protected Connection conexao;

	public AbstratoDAO() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lista05", "root", "admin");
		} catch (SQLException e) {
			System.out.println("Erro conectando ao banco de dados!");
		}
	}

	@Override
	public void close() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

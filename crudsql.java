import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class crudsql extends JFrame implements ActionListener {
    JTextArea queryArea, resultArea;
    JButton executeButton;
    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String user = "root";
    String password = "2006";
    Connection con;

    public crudsql() {
        setTitle("CRUD SQL");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        queryArea = new JTextArea(5, 50);
        queryArea.setBorder(BorderFactory.createTitledBorder("Enter MySQL Query"));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Result"));

        executeButton = new JButton("OK");
        executeButton.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JScrollPane(queryArea), BorderLayout.CENTER);
        topPanel.add(executeButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        connectDB();
        setVisible(true);
    }

    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            resultArea.setText("Connected to database successfully.\n");
        } catch (Exception e) {
            resultArea.setText("Database connection failed:\n" + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String query = queryArea.getText().trim();
        resultArea.setText("");

        try (Statement stmt = con.createStatement()) {
            if (query.toLowerCase().startsWith("select")) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    ResultSetMetaData meta = rs.getMetaData();
                    int cols = meta.getColumnCount();

                    // Print column headers
                    for (int i = 1; i <= cols; i++) {
                        resultArea.append(meta.getColumnName(i) + "\t");
                    }
                    resultArea.append("\n----------------------------------------------------------------\n");

                    while (rs.next()) {
                        for (int i = 1; i <= cols; i++) {
                            resultArea.append(rs.getString(i) + "\t");
                        }
                        resultArea.append("\n");
                    }
                }
            }
            else {
                int count = stmt.executeUpdate(query);
                resultArea.setText("Query executed successfully.\nRows affected: " + count);
            }
        } catch (Exception ex) {
            resultArea.setText("Error:\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new crudsql();
    }
}
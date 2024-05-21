package sl_5;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.code.R;

import java.util.List;

public class list_data_sqllite extends AppCompatActivity {

    private UserDAO userDAO;
    private ListView listView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_data_sqllite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        userDAO = new UserDAO(this);
        userDAO.open();
        insertSampleData(userDAO);
        List<User> users = userDAO.getAllUsers();
        userAdapter = new UserAdapter(this, users);
        listView.setAdapter(userAdapter);

        userDAO.close();
    }

    private void insertSampleData(UserDAO userDAO) {
        User user1 = new User("John Doe", "john.doe@example.com", R.drawable.ic_launcher_background);
        User user2 = new User("Jane Smith", "jane.smith@example.com", R.drawable.ic_launcher_background);
        User user3 = new User("Alice Johnson", "alice.johnson@example.com", R.drawable.ic_launcher_background);

        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
    }
}